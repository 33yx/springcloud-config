package com.example.demo.controller;


import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.util.StringUtils;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Controller
public class LoginController {
    @Autowired
   private UserService userService;

    @RequestMapping("/adminindex")
    public String login(@RequestParam("phone") String phone,
                        @RequestParam("password") String password,
                        HttpSession session,
                        RedirectAttributes redirectAttributes){
             User user=userService.findByUsernameAndPassword(phone,password);
             if(user !=null){
                 user.setPassword(null);
                 session.setAttribute("user",user);

                 return "/adminindex";
             }else {
                redirectAttributes.addFlashAttribute ("message","用户名和密码错误");

                 return "redirect:/login";
             }
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "/index.html";
    }



}
