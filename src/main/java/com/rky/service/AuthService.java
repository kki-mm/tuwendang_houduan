package com.rky.service;


import com.rky.pojo.*;

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
    boolean clickApprove(String projectId,Integer approveId,Integer result,String error_reason);


    String getProApprStat(String projectId);

    //暂未测试
    boolean canDownloadFile(Emp emp, Project project, Filee file);
    //暂未测试
    boolean canViewFile(Emp emp, Project project, Filee file);

    boolean isProjectMember(Integer personId,String projectId);

    List<Project> getNeedtoApprPro(Integer personId);

    List<ApprovePerson> getHaveApprPro(Integer personId);
    /*******************************************文件审批相关**************************/
    /**
     * 在文件上传接口中使用，暂时不供外
     */


    //没有测试，应该可以使用
    boolean setFileApprMember(String fileId,List<Integer>approves);

    boolean clickFileApprove(String fileId, Integer personId, Integer result,String error_reason);


    // 1 :proof  2: examine 3: approve   不是：null  (尽量不要出现) 查询审批人在对应文件id最新的一个里边的角色
    //此函数调用之前必须保证：personId 是审批人之一
    Integer getFileApprovePartById(Integer personId,String fileId);


    //查看某个审批人的审批结果  必须保证这个人是审批人 0 不通过 1 通过 2 暂未进行审批   null 啥也没有
    Integer getFileApprovePersonResultById(Integer personId,String fileId);


    List<Filee> getNeedtoApprFile(Integer personId);

    List<FileApprovePerson> getHaveApproFile(Integer personId);

    String getFileApprStat(String fileId);
}
