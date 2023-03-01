package com.xzf.springboot.controller;

import com.xzf.springboot.mongodb.JobDescription;
import com.xzf.springboot.pojo.*;
import com.xzf.springboot.service.JopService;
import com.xzf.springboot.service.ManagerService;
import com.xzf.springboot.service.SellerService;
import com.xzf.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
public class LoginController {

    @Autowired
    private ManagerService managerService;

    @Autowired
    private UserService userService;

    @Autowired
    private SellerService sellerService;

    @Autowired
    private JopService jopService;


    @PostMapping("/sys/index")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session, Model model) {

//        System.out.println(username+"    :  "+password);

        Manager manager = managerService.queryManagerToLogin(username, password);

        if (!StringUtils.isEmpty(manager.getMphone()) & !StringUtils.isEmpty(manager.getMpassword()) & manager.getState() == 1) {

            session.setAttribute("loginUser", manager);
            session.setAttribute("state", manager.getState());


            model.addAttribute("identity", username);
            System.out.println("进入这里");
            return "index";

        } else {
//            model.addAttribute("msg","用户名或密码错误！");
            return "redirect:/login";
        }
    }

    //退出
    @GetMapping("/sys/loginOut")
    public String loginOut(HttpSession session) {
        //清空session
        session.setAttribute("loginUser", null);
        return "login";
    }

    //前端登陆
    @PostMapping("/sys/indexss")
    @ResponseBody
    public ResultLogin loginsdutent(String email, String password, Integer identity, HttpSession session) {
        User user = null;
        ResultLogin resultLogin=null;

        if (identity == 1) {//学生
            user = userService.queryUserToLogin(email, password);
            if (!StringUtils.isEmpty(user.getPhone()) & !StringUtils.isEmpty(user.getPassword()) & user.getStatus() == 1) {
                session.setAttribute("loginUser", user);
                session.setAttribute("state", user.getStatus());

                resultLogin=new ResultLogin(0001,identity,user,null);

            } else if (identity == 2) {//商户

            }





        }
        return resultLogin;
    }
//    @GetMapping("/fore/order-list")
//    @ResponseBody
//    public Result orderList(String username, HttpSession session){
//        List<Jop> jopsD=new ArrayList<>();
//        JobDescription jobDescription;
//        List<Jop> jops=null;
//        session.setAttribute("loginUser", username);
////        if (!StringUtils.isEmpty(username)){
////             jops=jopService.queryJopList();
////        }
//        jops=jopService.queryJopList();
//        System.out.println("进入查找"+jops);
//
//        Result result= new Result(0001,"akuhkba");
//
//        return result;
//
//    }






//    @GetMapping("/sys/addusera")
//    @ResponseBody
//    public Result addu(User user){
//        System.out.println("成功进入");
//        System.out.println(user);
//
//        Result result=new Result(0001,"成功");
//
//        return result;
//    }




}