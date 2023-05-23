package com.rky.controller;


import com.rky.pojo.Emp;
import com.rky.pojo.Result;
import com.rky.service.EmpService;
import com.rky.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    EmpService empService;
    /*根据用户名和密码查询员工*/
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("用户登录校验");
        //1. 根据用户名查寻用户
        Emp e = empService.login(emp);
        //2. 判断是否查询到用户 若查询到，给jwt令牌
        if(e!=null){
            Map<String,Object>claims = new HashMap<>();
            claims.put("username",e.getUsername());
            claims.put("personId",e.getPersonId());
            claims.put("name",e.getName());
            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");
    }
}
