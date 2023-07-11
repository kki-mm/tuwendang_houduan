package com.rky.controller;


import com.rky.pojo.*;
import com.rky.service.AuthService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthController {
    @Autowired
    AuthService authService;
    /*@GetMapping("/auth/pro")
    Result getProApprStat(String projectId){
        String result = authService.getProApprStat(projectId);
       return Result.success(result);
    }*/


    //error_reason 非必填
    @GetMapping("/auth/setProjAppro")
    Result clickProApprove(String projectId,Integer approveId,Integer result,String error_reason){
        boolean stat = authService.clickApprove(projectId,approveId,result,error_reason);
        return Result.success(stat);
    }

    @GetMapping("/auth/getproAppStat")
    Result getProjectApprStat(String projectId){
        String stat = authService.getProApprStat(projectId);
        return Result.success(stat);
    }


    /*
    * 得到待审批项目
    *
    * 输入：自己person_id
    *
    * 返回：待审批项目List<Project>
    * */
    @GetMapping("/auth/getNeedtoApprPro")
    Result getNeedtoApprPro(Integer personId){
        List<Project> projectList = authService.getNeedtoApprPro(personId);
        return Result.success(projectList);
    }


    /*
    * 得到已审批项目
    *
    * 输入：personId
    *
    * 输出：已审批项目记录，但不是返回项目
    *  项目id 自己审批状态（前端自己去找哪一个审批状态不为空就是哪一个），自己审批时间（也是不为空的哪一个为自己的审批时间）
    * */
    @GetMapping("auth/getHaveApprPro")
    Result getHaveApprPro(Integer personId){
        List<ApprovePerson> approvePersonList = authService.getHaveApprPro(personId);
        return Result.success(approvePersonList);
    }

     /******************************文件审批相关*****************************************************/

    @GetMapping("/auth/setFileAppro")
    Result clickFileApprove(String fileId,Integer personId,Integer result,String error_reason){
        boolean stat = authService.clickFileApprove(fileId,personId,result,error_reason);
        return Result.success(stat);
    }

    @GetMapping("/auth/getNeedtoApprFile")
    Result getNeedtoApprFile(Integer personId){
        List<Filee>fileeList = authService.getNeedtoApprFile(personId);
        return Result.success();
    }

    @GetMapping("/auth/getHaveApprFile")
    Result getHaveApproFile(Integer personId){
        List<FileApprovePerson> fileApprovePersonList = authService.getHaveApproFile(personId);
        return Result.success(fileApprovePersonList);
    }

    Result getFileApprStat(String fileId){
        String stat = authService.getFileApprStat(fileId);
        return Result.success(stat);
    }

}
