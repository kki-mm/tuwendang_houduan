package com.rky.service;


import com.rky.pojo.Emp;
import com.rky.pojo.Filee;
import com.rky.pojo.Project;

import java.util.List;

public interface AuthService {
    /*
          内部使用函数，不对外
          输入： 项目 id 项目审批人ID ，审批人可能有多个
          功能：新建项目时提交项目申请
    * */
    boolean sendApprove(String projectId, List<Integer> approveIds);
/*
        内部使用函数，不对外
        功能：进行审批操作，并会自动更新该项目审批状况
        输入：项目ID，审批人ID，是否同意
*/
    boolean clickApprove(String projectId,Integer approveId,Integer result);


    String getProApprStat(String projectId);


    boolean canDownloadFile(Emp emp, Project project, Filee file);

    boolean canViewFile(Emp emp, Project project, Filee file);

    boolean isProjectMember(Integer personId,String projectId);
}
