package com.rky.controller;


import com.rky.pojo.Result;
import com.rky.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    AuthService authService;
    @GetMapping("/auth/pro")
    Result getProApprStat(String projectId){
        String result = authService.getProApprStat(projectId);
       return Result.success(result);
    }

    @GetMapping("/auth/setAppro")
    Result clickApprove(String projectId,Integer approveId,Integer result){
        boolean stat = authService.clickApprove(projectId,approveId,result);
        return Result.success(stat);
    }


}
