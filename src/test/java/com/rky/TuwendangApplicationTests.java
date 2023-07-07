package com.rky;

import com.rky.mapper.AuthMapper;
import com.rky.pojo.ApprovePerson;
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
        System.out.println(authService.isProjectMember(8,"546566"));
    }

}
