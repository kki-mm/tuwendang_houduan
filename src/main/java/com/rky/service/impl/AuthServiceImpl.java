package com.rky.service.impl;

import com.rky.mapper.AuthMapper;
import com.rky.pojo.*;
import com.rky.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public boolean clickApprove(String projectId, Integer approveId, Integer result,String error_reason) {

 /*
 *
 * */



        int personFlag = 0;
        //0.查询 当前审批人是person几
       // List<ApprovePerson>allPerson = authMapper.selectAllPerson(projectId);//可能会有多次审批记录，我们想要得到的应该是最新的


        //查找approve = 0 and projectId  = this.projectId
        ApprovePerson latest = authMapper.selectApprovePerson(projectId);
       // ApprovePerson latest = allPerson.get(allPerson.size()-1);
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

        ApprovePerson latest2 = authMapper.getByIdProject(latest.getId());//因为用的是id，所以不存在重复
        if(result==1){
            //3.查看是否项目审批通过，若通过，更新approve字段
            //(1)得到审批结果


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
                //还需要更新Project表的is_approve 为 1
                authMapper.setProjectSucc(projectId);
            }

        } else if (result==0) {
            //将这个审批记录approve 设为 2，就是这一条审批记录不是正在活动的审批进程了，只用来存档 还需发送通知告知退回
            authMapper.setProUnuse(latest2.getId());
            //设置打回原因
            authMapper.setErroReason(latest2.getId(),error_reason);
        }


        return true;
    }


    /*返回的为字符串 审批中 审批通过 审批失败*/
    @Override
    public String getProApprStat(String projectId) {
        //List<ApprovePerson> allApprove = authMapper.selectAllPerson(projectId);
        //ApprovePerson latest = allApprove.get(allApprove.size()-1);
        ApprovePerson latest = authMapper.getLatestAppr(projectId);

        Integer flag_0 = 0; //拒绝人id

        Integer flag_1 = 0;

        LocalDateTime personTime= LocalDateTime.now();

        if(latest.getApprove()==2){
            if(latest.getPerson1Stat()==0){
                flag_0 = latest.getPerson1();
            }
            else if(latest.getPerson2Stat()==0){
                flag_0 = latest.getPerson2();
            }
            else if(latest.getPerson3Stat()==0){
                flag_0 = latest.getPerson3();
            }
            else if(latest.getPerson4Stat()==0){
                flag_0 = latest.getPerson4();
            }
            else if(latest.getPerson5Stat()==0){
                flag_0 = latest.getPerson5();
            }

        }else if(latest.getApprove()==0){
            //去判断哪一个人已经审批
            if(latest.getPerson1Stat()==1){
                flag_1 = latest.getPerson1();
                personTime = latest.getPerson1Time();
            }
            else if(latest.getPerson2Stat()==1){
                flag_1 = latest.getPerson2();
                personTime = latest.getPerson2Time();
            }
            else if(latest.getPerson3Stat()==1){
                flag_1 = latest.getPerson3();
                personTime = latest.getPerson3Time();
            }
            else if(latest.getPerson4Stat()==1){
                flag_1 = latest.getPerson4();
                personTime = latest.getPerson4Time();
            }
            else if(latest.getPerson5Stat()==1){
                flag_1 = latest.getPerson5();
                personTime = latest.getPerson5Time();
            }
        }

        String name_0 = authMapper.getUserNameByID(flag_0);
        String name_1 = authMapper.getUserNameByID(flag_1);


        if(latest.getApprove()==2){
            return "审批状态："+"不通过"+","+"退回人："+name_0+","+"退回时间："+latest.getUpdateTime()+","+"退回原因："+latest.getErrorReason(); //若不通过，返回原因；
        } else if (latest.getApprove()==1) {
            return "审批状态：审批通过,审批时间："+latest.getUpdateTime();
        } else{
            if(flag_1==0){
                return "审批状态:审批中,已审批人:暂无人审批";
            }else{
                return "审批状态:审批中,已审批人:"+name_1+",审批时间："+personTime;
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

    //新建文件调用函数，并不给前端调用：插入文件审批记录
    //List 传入顺序 proofPersonId examinePersonId approvePersonId
    //不设定哪一部，传0
    @Override
    public boolean setFileApprMember(String fileId, List<Integer> approves) {
        Integer proofPersonId = approves.get(0);
        Integer examinePersonId = approves.get(1);
        Integer approvePersonId = approves.get(2);


        authMapper.setFileApprMember(fileId,proofPersonId,examinePersonId,approvePersonId);

        //查看当前审批的文件

        //1.判断第一个不为0 的 人
            //将他的is_view 设置为可见

        if(proofPersonId!=0){
            //设置isview//设置最新的审批记录
            authMapper.setProofView(fileId);

            //消息通知
            return true;
        } else if (examinePersonId!=0) {
            //设置view
            authMapper.setExamineView(fileId);
            //消息通知
            return true;
        }else if(approvePersonId!=0){
            //设置view
            authMapper.setApproveView(fileId);
            //消息通知
            return true;
        }


        return false;
    }

    @Override
    public boolean clickFileApprove(String fileId, Integer personId, Integer result,String error_reason) {
       //1.查找出fileId
        //List<FileApprovePerson> fileApprovePersonList = authMapper.selectAllFileApprovePerson(fileId);
        //2.可能审批多次，可能存在多条记录，取最后的一条记录//
        FileApprovePerson fileApprovePerson = authMapper.selectFileApproLatest(fileId);//这个肯定不是空的
        //3.判断当前用户属于哪一个审批角色
        Integer flag = 0;
        if(fileApprovePerson.getProofPerson()==personId){
            flag = 1;
        } else if (fileApprovePerson.getExaminePerson()==personId) {
            flag = 2;
        } else if (fileApprovePerson.getApprovePerson()==personId) {
            flag = 3;
        }
        //

        //4.根据角色 设置审批结果
        authMapper.setFileAprrStat(fileId,flag,result,error_reason);
        //5.若当前审批结果为通过，则给下一审批人发送通知（若有下一审批人的情况下），若没有，则更新文件审批状态
        if(result==1){
            //(1). 判断是否有下一审批人
            if(flag==1){
                if(fileApprovePerson.getExaminePerson()!=null){
                    //给这个人发送审批通知
                    //log.info("geiexaminePerson 发送审批通知");
                    //让这个人可见
                    authMapper.setExamineView(fileId);
                    System.out.println("给"+fileApprovePerson.getExaminePerson()+"发送审批通知");
                } else if (fileApprovePerson.getApprovePerson()!=null) {
                    authMapper.setApproveView(fileId);
                    System.out.println("给"+fileApprovePerson.getApprovePerson()+"发送审批通知");
                    //给这个人发送审批通知
                }else{
                    //也就是只有他自己审核
                    //当前文件审核结束，更新文件审核状态
                    authMapper.setFileApprSucess(fileId);
                    //更新文件表
                    authMapper.setFileApprove(fileId); //看看是不是要修改//修改找is_approve为2的


                }

            } else if (flag==2) {
                //第一个审批人没有，或者第一个已经审批通过的情况
                if(fileApprovePerson.getApprovePerson()!=null){
                    //存在第三个审批人
                    //给第三个发送审批通知
                    authMapper.setApproveView(fileId);
                    System.out.println("给"+fileApprovePerson.getApprovePerson()+"发送审批通知");
                }else{
                    //没有第三个人
                    //他就是最终审批人，更新文件审批状态
                    authMapper.setFileApprSucess(fileId);
                    //更新文件表
                    authMapper.setFileApprove(fileId);
                }
            } else if (flag==3) {
                //更新文件审批状态
                authMapper.setFileApprSucess(fileId);
                //更新文件表
                authMapper.setFileApprove(fileId);
            }
        }else{
            //(2).设置文件审批表 is_approve = 2
                authMapper.setFileApprError(fileId);
                //要不要设置文件表为 0
                authMapper.setFileError(fileId);
        }


        //6.若不通过，则不进行任何操作
        return true;
    }

    @Override
    public Integer getFileApprovePartById(Integer personId, String fileId) {
        FileApprovePerson fileApprovePerson = authMapper.getFileApprovePartById(personId,fileId);
        if(fileApprovePerson.getProofPerson()==personId){
            return 1;
        } else if (fileApprovePerson.getExaminePerson()==personId) {
            return 2;
        } else if(fileApprovePerson.getApprovePerson()==personId){
            return 3;
        }

        return null;
    }

    @Override
    public Integer getFileApprovePersonResultById(Integer personId, String fileId) {

        Integer flag = this.getFileApprovePartById(personId,fileId);// 0 啥也不是 1 proof 2 examine 3 approve

       if(flag==1){
           //select proof state
        Integer stat = authMapper.getProofStat(fileId);
        return stat;
       } else if (flag==2) {
           Integer stat = authMapper.getExamineStat(fileId);
       } else if (flag==3) {
           Integer stat = authMapper.getApproveStat(fileId);
       }

       return null;
    }

    @Override
    public List<Filee> getNeedtoApprFile(Integer personId) {
        List<String>fileIdsList = authMapper.getNeedtoApprFileIds(personId);

        if(!fileIdsList.isEmpty()){
            List<Filee>fileeList = authMapper.getNeedtoApprFile(fileIdsList);
            return fileeList;
        }else{
            return null;
        }
    }

    @Override
    public List<FileApprovePerson> getHaveApproFile(Integer personId) {
        List<FileApprovePerson>fileApprovePersonList = authMapper.getHaveApproFile(personId);
        return fileApprovePersonList;
    }

    @Override
    public String getFileApprStat(String fileId) {

        FileApprovePerson fileApprovePerson = authMapper.selectFileApproLatest(fileId);
        Integer flag0 = null;
        String name0 = "";

        if(fileApprovePerson.getIsApprove()==2){
            if(fileApprovePerson.getProofPersonStat()==0){
                flag0 = 1;
                name0 = authMapper.getUserNameByID(fileApprovePerson.getProofPerson());
            } else if (fileApprovePerson.getExaminePersonStat()==0) {
                flag0 = 2;
                name0 = authMapper.getUserNameByID(fileApprovePerson.getExaminePerson());
            } else if (fileApprovePerson.getApprovePersonStat()==0) {
                flag0 = 3;
                name0 = authMapper.getUserNameByID(fileApprovePerson.getApprovePerson());
            }

            return "审批状态:不通过,审批人："+name0+",审批时间："+fileApprovePerson.getUpdateTime().toString()+",退回意见："+fileApprovePerson.getErrorReason();
        }


        Integer flag1 = null;
        Integer flag2 = null;
        Integer flag3 = null;
        String name1 = null;
        String name2 = null;
        String name3 = null;

        if(fileApprovePerson.getIsApprove()==0){
           if(fileApprovePerson.getProofPerson()!=null&&fileApprovePerson.getProofPersonStat()!=2){
               //这个人审批了
               name1 = authMapper.getUserNameByID(fileApprovePerson.getProofPerson());
               if(fileApprovePerson.getExaminePersonStat()!=2){
                   //这个也审批了
                   name2 = authMapper.getUserNameByID(fileApprovePerson.getExaminePerson());
                   return "审批状态：审批中,已审批人："+name1+","+name2+"审批时间："+fileApprovePerson.getUpdateTime();
               }
               return "审批状态：审批中,已审批人："+name1+"审批时间："+fileApprovePerson.getUpdateTime();
           }else if(fileApprovePerson.getApprovePerson()==null){
               if(fileApprovePerson.getExaminePerson()!=null&&fileApprovePerson.getExaminePersonStat()!=2){
                   //第二个审批了
                   name1 = authMapper.getUserNameByID(fileApprovePerson.getExaminePerson());
                   return "审批状态：审批中,已审批人："+name1+"审批时间："+fileApprovePerson.getUpdateTime();
               }
           }else{
               return "审批状态：审批中,已审批人：暂无人审批";
           }
        }

        if(fileApprovePerson.getIsApprove()==1){
            return "审批状态：审批通过,审批时间："+fileApprovePerson.getUpdateTime().toString();
        }


        return null;
    }

    @Override
    public List<Project> getNeedtoApprPro(Integer personId) {
        //1.获得所有项目Id
        List<String>projectIds = authMapper.getNeedtoApprPro(personId);
        //2.查询相关项目
        //
        //String projects_temp = projectIds.toString();
       // String projects ="("+projects_temp.substring(1,projects_temp.length()-1)+")";
        if(!projectIds.isEmpty()){
            List<Project>projectList = authMapper.getProjectList(projectIds);
            return projectList;
        }else{
            return null;
        }



    }

    @Override
    public List<ApprovePerson> getHaveApprPro(Integer personId) {
        List<ApprovePerson>approvePersonList = authMapper.getHaveApprPro(personId);
        return approvePersonList;
    }
}
