package com.rky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


//@ServletComponentScan   //为了使用filter
@SpringBootApplication
public class TuwendangApplication {

    public static void main(String[] args) {
        SpringApplication.run(TuwendangApplication.class, args);
    }

}
