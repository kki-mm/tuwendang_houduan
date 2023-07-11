package com.rky;

import com.aspose.cad.internal.Y.S;
import com.aspose.cad.internal.m.I;
import com.rky.mapper.AuthMapper;
import com.rky.pojo.ApprovePerson;
import com.rky.pojo.FileApprovePerson;
import com.rky.pojo.Filee;
import com.rky.pojo.Project;
import com.rky.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
class TuwendangApplicationTests {
    @Autowired
    AuthService authService;
    @Autowired
    AuthMapper authMapper;
    @Test
    void testAuth(){
        String projectId ="1111";
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(3);
        ids.add(4);
/*
       // authService.sendApprove(projectId,ids);
        List<ApprovePerson>all = authMapper.selectAllPerson(projectId);
        ApprovePerson latest = all.get(all.size()-1);

        System.out.println(all);
        System.out.println("*************");
        System.out.println(latest);*/

        //authService.clickApprove(projectId,3,0);
        //System.out.println(authService.getProApprStat(projectId));
       // System.out.println(authService.isProjectMember(8,"546566"));
       // String fileId = "11";
       // List<Integer> empList = new ArrayList<Integer>();
       // empList.add(1);
        //empList.add(0);
        //empList.add(3);
        //authService.setFileApprMember(fileId,empList);
    }



    /*
    * 设置项目审批人员*/
    @Test
    void testSetProjectAuthPerson(){
        String projectId ="111";
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(2);
        ids.add(3);
        ids.add(5);
        authService.sendApprove(projectId,ids);
    }

    @Test
    void testClickToApproveProject(){
        //authService.clickApprove("5465663",2,1,"");
        authService.clickApprove("111",5,1,"5888");

    }

    @Test
    void testProjectApproStat(){
        String projectId = "111";
        String result = authService.getProApprStat(projectId);
        System.out.println(result);
    }


    @Test
    void testDaiSenPi(){
        Integer personId = 5;
        List<Project>projectList = authService.getNeedtoApprPro(personId);
        System.out.println(projectList);

    }

    @Test
    void testYiShenPi(){
        Integer personId = 5;
        List<ApprovePerson>approvePersonList = authService.getHaveApprPro(personId);
        System.out.println(approvePersonList);
    }
/************************文件审批接口测试****************************/
    @Test
    void testSetFileApprove(){

        String fileId = "113_3";
        List<Integer>ids = new ArrayList<Integer>();
        ids.add(0);
        ids.add(3);
        ids.add(5);
        authService.setFileApprMember(fileId,ids);
    }

    @Test
    void testClickApproveFile(){
        String fileId = "113_3";
        Integer personId = 5;
        Integer result = 1;
        authService.clickFileApprove(fileId,personId,result,"111");
    }

    @Test
    void testHaveApproveFile(){
        Integer personId = 5;
        List<FileApprovePerson>fileApprovePersonList = authService.getHaveApproFile(personId);
        System.out.println(fileApprovePersonList);
    }


    @Test
    void testFileApproveStat(){
        String fileId = "113_3";
        String stat = authService.getFileApprStat(fileId);
        System.out.println(stat);
    }



    //这个有问题
    @Test
    void testFileGetNeedtoAppr(){
        List<Filee>fileeList = authService.getNeedtoApprFile(5);
        System.out.println(fileeList);
    }



}
