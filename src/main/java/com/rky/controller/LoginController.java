package com.rky.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @RequestMapping("Test")
    public String Test(){
        return "OKK";
    }
}
