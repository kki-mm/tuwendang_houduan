package com.rky.service.impl;

import com.rky.mapper.AuthMapper;
import com.rky.pojo.ApprovePerson;
import com.rky.pojo.Emp;
import com.rky.pojo.Filee;
import com.rky.pojo.Project;
import com.rky.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    AuthMapper authMapper;
    @Override
    public boolean sendApprove(String projectId, List<Integer> approveIds) {
        int num = approveIds.size();//审批人个数
        /*审批人个数不能小于2个，但是不能多5个*/
        if(num<2||num>5){
            return false;
        }
        /*更新数据库，将project_approve数据库更新新的审批人*/
        authMapper.insert(projectId,approveIds);

        //向审批人发送通知（待写）


        return true;
    }

    @Override
    public boolean clickApprove(String projectId, Integer approveId, Integer result) {
        int personFlag = 0;
        //0.查询 当前审批人是person几
        List<ApprovePerson>allPerson = authMapper.selectAllPerson(projectId);//可能会有多次审批记录，我们想要得到的应该是最新的
        ApprovePerson latest = allPerson.get(allPerson.size()-1);
        if(latest.getPerson1()== approveId){
            personFlag = 1;
        }
        if(latest.getPerson2()== approveId){
            personFlag = 2;
        }
        if(latest.getPerson3()== approveId){
            personFlag = 3;
        }
        if(latest.getPerson4()== approveId){
            personFlag = 4;
        }
        if(latest.getPerson5()== approveId){
            personFlag = 5;
        }

        //1.根据项目id 审批人id 找到project_approve 表中的对应person_i_stat 字段 //2.更新person_i_stat字段
        authMapper.updataStat(projectId,result,personFlag,latest.getId());//personFlag代表哪一个人


        if(result==1){
            //3.查看是否项目审批通过，若通过，更新approve字段
            //(1)得到审批结果
            ApprovePerson latest2 = authMapper.getByIdProject(latest.getId());

            int flag = 0;
            if(latest2.getPerson1Stat()==1){
                flag++;
            }
            if(latest2.getPerson2Stat()==1){
                flag++;
            }
            if(latest2.getPerson3Stat()==1){
                flag++;
            }
            if(latest2.getPerson4Stat()==1){
                flag++;
            }
            if(latest2.getPerson5Stat()==1){
                flag++;
            }
            if(flag>=2){
                //更新approve 字段
                authMapper.setProAutSuss(latest2.getId());
            }

        }


        return true;
    }

    @Override
    public String getProApprStat(String projectId) {
        List<ApprovePerson> allApprove = authMapper.selectAllPerson(projectId);
        ApprovePerson latest = allApprove.get(allApprove.size()-1);
        int flag = 0;
        int flag2 = 0;
        if(latest.getPerson1Stat()==1){
            flag++;
        }
        if(latest.getPerson2Stat()==1){
            flag++;
        }
        if(latest.getPerson3Stat()==1){
            flag++;
        }
        if(latest.getPerson4Stat()==1){
            flag++;
        }
        if(latest.getPerson5Stat()==1){
            flag++;
        }

        if(latest.getPerson1Stat()==2){
            flag2++;
        }
        if(latest.getPerson2Stat()==2){
            flag2++;
        }
        if(latest.getPerson3Stat()==2){
            flag2++;
        }
        if(latest.getPerson4Stat()==2){
            flag2++;
        }
        if(latest.getPerson5Stat()==2){
            flag2++;
        }

        if(flag>=2){
            return "审批通过";
        }else{
            if(flag2>3){
                return "审批中";
            }else{
                return "审批不通过";
            }
        }



    }

    @Override
    public boolean canDownloadFile(Emp emp, Project project, Filee file) {

        Integer empRoomId = authMapper.getRoomIdByName("研发室");

        //1.判断是否在项目周期内，执行项目周期内逻辑
        if(project.getEndTime()!=null){

            if(((emp.getJob()=="室主任")&&(emp.getRoomId()==file.getRoomId())&&(emp.getDepartId()==project.getDepartId()))
                    ||((emp.getJob()=="部长")&&(emp.getDepartId()==project.getDepartId()))
                    ||((emp.getJob()=="副部长")&&(emp.getDepartId()==project.getDepartId()))
                    ||((emp.getJob()=="室主任")&&(emp.getRoomId()==empRoomId)&&(emp.getDepartId()==project.getDepartId()))
            ){
                if(file.getDocumentType()=="项目交接表"){
                    if(((emp.getJob()=="部长")&&(emp.getDepartId()==project.getDepartId()))
                            ||((emp.getJob()=="副部长")&&(emp.getDepartId()==project.getDepartId()))
                            ||((emp.getJob()=="室主任")&&(emp.getRoomId()==empRoomId)&&(emp.getDepartId()==project.getDepartId()))){
                        return true;
                    }else{
                        return false;
                    }
                }
                return true;
            } else if (file.getUploadName()==emp.getName()) {
                return true;
            }else{
                return false;
            }

        }else{
            //项目周期外
            if(((emp.getJob()=="室主任")&&(emp.getRoomId()==file.getRoomId())&&(emp.getDepartId()==project.getDepartId()))
                    ||((emp.getJob()=="部长")&&(emp.getDepartId()==project.getDepartId()))
                    ||((emp.getJob()=="副部长")&&(emp.getDepartId()==project.getDepartId()))
                    ||((emp.getJob()=="室主任")&&(emp.getRoomId()==empRoomId)&&(emp.getDepartId()==project.getDepartId()))){
                if(file.getDocumentType()=="项目交接表"){
                    return false;
                }else{
                    return true;
                }
            }else {
                return  false;
            }

        }


    }

    @Override
    public boolean canViewFile(Emp emp, Project project, Filee file) {
        Integer empRoomId = authMapper.getRoomIdByName("研发室");
        if(project.getEndTime()!=null){
            //项目周期内
            if(emp.getDepartId()==project.getDepartId()){
                if(emp.getJob()=="文员"){
                    return false;
                }else{
                    return true;
                }
            }else{
                return false;
            }
        }else{
            //项目周期外

            //自己传的文件
            if(emp.getName()==file.getUploadName()){
                return true;
            }
            //判断是否为项目成员
           if(this.isProjectMember(emp.getPersonId(),project.getProjectId())){
               //只能看项目交接表和供外文件
               if(file.getDocumentType()=="项目交接表"||file.getIsGiveOut()==1){
                   return true;
               }else{
                   return false;
               }
           }
           if(((emp.getJob()=="室主任")&&(emp.getRoomId()==file.getRoomId())&&(emp.getDepartId()==project.getDepartId()))
                   ||((emp.getJob()=="部长")&&(emp.getDepartId()==project.getDepartId()))
                   ||((emp.getJob()=="副部长")&&(emp.getDepartId()==project.getDepartId()))
                   ||((emp.getJob()=="室主任")&&(emp.getRoomId()==empRoomId)&&(emp.getDepartId()==project.getDepartId()))){
               return true;
            }
           return false;
        }
    }

    @Override
    public boolean isProjectMember(Integer personId, String projectId) {
        Integer num = authMapper.isProjectMember(personId,projectId);
        if(num>0){
            return true;
        }else{
            return false;
        }
    }
}
