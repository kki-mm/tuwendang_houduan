package com.rky.filter;

import com.alibaba.fastjson.JSONObject;
import com.rky.pojo.Result;
import com.rky.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")   //拦截所有请求
public class LoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 1. 获取请求url
        String url = request.getRequestURI().toString();
        log.info("请求的url:{}",url);
        //2. 判断是否为login 请求
        if(url.contains("login")){
            log.info("登录操作，放行");
            filterChain.doFilter(request,response);
            return;
        }
        //3.判断是否有token
        String jwt = request.getHeader("token");
        if(!StringUtils.hasLength(jwt)){
            log.info("请求头中未含有token,未登录");
            Result result = Result.error("NOT_LOGIN "); //使用fastjson 工具包将对象类型转换为json
            String jsonResult = JSONObject.toJSONString(result);
            response.getWriter().write(jsonResult);
            return;

        }
        //4.解析token
        try {
            JwtUtils.parseJWT(jwt);
        }catch(Exception e){
            e.printStackTrace();
            log.info("token 解析失败");

            Result result = Result.error("NOT_LOGIN "); //使用fastjson 工具包将对象类型转换为json
            String jsonResult = JSONObject.toJSONString(result);
            response.getWriter().write(jsonResult);
            return;
        }
        //5. 放行

        log.info("零牌合法");
        filterChain.doFilter(request,response);
    }
}
