package com.xzf.springboot.controller;

import com.xzf.springboot.pojo.Manager;
import com.xzf.springboot.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private ManagerService managerService;


    @PostMapping   ("/sys/index")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session, Model model){

        System.out.println(username+"    :  "+password);

        Manager manager=managerService.queryManagerToLogin(username,password);

        System.out.println(manager);


        if (!StringUtils.isEmpty(manager.getMphone()) & !StringUtils.isEmpty(manager.getMpassword()) & manager.getState()==1) {

            session.setAttribute("loginUser",username);
            model.addAttribute("identity",username);

            return "index";

        }else {
//            model.addAttribute("msg","用户名或密码错误！");
            return "redirect:/login";
        }

    }

}
