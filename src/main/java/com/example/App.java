package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@EnableAutoConfiguration  // 開啟SpringBoot自動化配置的引入
@RestController
public class App
{
    @RequestMapping("/")
    public String home(){
        int b=123,a=111,ans;
        ans=b + a;
        return "test123123123123"+"/n"+"嗨嗨嗨"+ans;
    }
    @GetMapping("x")
    public String hello(){
        return "Hey, Spring Boot 的 Hello World !";
    }
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
        SpringApplication.run(App.class,args);
    }
}
