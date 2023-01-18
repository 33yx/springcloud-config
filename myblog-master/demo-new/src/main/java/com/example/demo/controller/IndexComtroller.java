package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexComtroller {
    @RequestMapping("/archives")
       public String archives(){
         return "/archives.html";
     }
    @RequestMapping("/login")
    public String login(){
        return "/login.html";
    }
    @RequestMapping("/register")
    public String register(){
        return "/register";
    }
    @RequestMapping("/superadmin")
    public String superadmin(){
        return "/superadmin";
    }
    @RequestMapping("/update")
    public String update(){
        return "/update";
    }
}

