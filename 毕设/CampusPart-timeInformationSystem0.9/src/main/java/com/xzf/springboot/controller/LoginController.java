package com.xzf.springboot.controller;

import com.xzf.springboot.pojo.*;
import com.xzf.springboot.pojo.tool.Result;
import com.xzf.springboot.pojo.tool.ResultCode;
import com.xzf.springboot.pojo.tool.ResultLogin;
import com.xzf.springboot.service.*;
import com.xzf.springboot.tool.EmailUtil;
import com.xzf.springboot.tool.ValidateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    private Emailservice emailservice;

//    @Autowired
//    private JopService jopService;


    @PostMapping("/sys/index")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,HttpSession session, Model model) {
//        System.out.println(username+"    :  "+password);
        Manager manager = managerService.queryManagerToLogin(username, password);
        if (!StringUtils.isEmpty(manager.getMphone()) & !StringUtils.isEmpty(manager.getMpassword()) & manager.getState() == 1) {
            session.setAttribute("loginUser", manager);
            session.setAttribute("state", manager.getState());
            session.setAttribute("identity", username);
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
    @PostMapping("/fore/indexss")
    @ResponseBody
    public ResultLogin loginsdutent(String email, String password, Integer identity, HttpSession session) {
        User user = null;
        Seller seller=null;
        ResultLogin resultLogin=null;
        if (identity == 1) {//学生
            user = userService.queryUserToLogin(email, password);
            if (user !=null){
                if (user.getStatus() == 1) {
                    session.setAttribute("loginUser", user);
                    session.setAttribute("state", user.getStatus());
                    resultLogin=new ResultLogin(0001,identity,user,null,"成功");
                }else {
                    resultLogin=new ResultLogin(0002,null,null,null,"账号不可用");
                }
            }else {
                resultLogin=new ResultLogin(0002,null,null,null,"账号或密码不正确");
            }
        }
        else if (identity == 2) {//商户
            seller = sellerService.querySellerToLogin(email, password);
            if (seller !=null){
                if (seller.getSstatus() == 1) {
                    session.setAttribute("loginUser", seller);
                    session.setAttribute("state", seller.getSstatus());
                    resultLogin=new ResultLogin(0003,identity,null,seller,"成功");
                }
                else {
                    resultLogin=new ResultLogin(0002,null,null,null,"账号不可用");
                }
            }else {
                resultLogin=new ResultLogin(0002,null,null,null,"账号或密码不正确");
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

    @PostMapping("/fore/sendMsg")
    @ResponseBody
    public ResultCode sendMsg(String email, String uphone, HttpSession session){
        //获取邮箱
        String phone = email;
        String i=uphone;
        ResultCode result=null;
        if(!StringUtils.isEmpty(phone)){
            //生成随机的4位验证码
            String code = ValidateCodeUtils.generateValidateCode(4).toString();
            //调用自己封装的qq邮箱发送器发送邮箱
            emailservice.sendemail(phone,code);
//            EmailUtil.sendAuthCodeEmail(phone,code);
            //需要将验证码保存到session中
            session.setMaxInactiveInterval(60); //设置session有效期 60秒,这里以后可能会用redis,所以先不设置！
            result= new ResultCode(0001,"邮箱验证码发送成功",code);
        }else {
            result=new ResultCode(0002,"邮箱发送失败",null);
        }
        return result;
    }



    //注册学生用户
    @PostMapping("/fore/addusera")
    @ResponseBody
    public Result addu(String uemail, String uname, String address, String usename, Integer useage, String schoollname, String studentid, String cardid, String phone, String password, String usex, String code, HttpServletRequest request){//
        Result result=null;
        User user=new User();
        int u=0;
        Integer i=null;
        i=userService.queryUserListByphone(phone);
            if (i==null){
                user.setUsename(usename);
                user.setUname(uname);
                user.setUseage(useage);
                user.setSchoollname(schoollname);
                user.setStudentid(studentid);
                user.setStatus(1);
                user.setCardid(cardid);
                user.setUsex(usex);
                user.setPhone(phone);
                user.setAddress(address);
                user.setUemail(uemail);
                user.setPassword(password);
                u=userService.addUser(user);
                result=new Result(0001,"注册成功");
            }else {
                result=new Result(0002,"注册失败");
            }
        return result;
    }
    //注册商家
    @PostMapping("/fore/addSellor")
    @ResponseBody
    public Result adds(String uemail, String uname, String address, String ssname, Integer useage, String sbus, String cardid, String phone, String password, String usex, String code, HttpServletRequest request){//
        Result result=null;
        Seller seller=new Seller();
        Card card=new Card();
        int u=0;
        Integer i=null;
        i=sellerService.querySellertAndCardByphone(phone);
        if (i==0001){
//            seller.setSellerid(SAC.getSellerid());
            seller.setSname(ssname);
            seller.setSaddress(address);
            seller.setBusinesslicense(sbus);
            seller.setSphone(phone);
            seller.setSpasswoed(password);
            seller.setSsex(usex);
            seller.setSemail(uemail);
            seller.setSstatus(1);
            card.setCphone(phone);
            card.setCarid(cardid);
            card.setCname(uname);
            card.setCage(String.valueOf(useage));


            sellerService.addSeller(seller,card);
            result=new Result(0001,"注册成功");
        }else if (i==0002){
            result=new Result(0002,"注册失败：该账号已经存在但未绑定身份证");
        }else if (i==0003){
            result=new Result(0002,"注册失败：账号已经存在");
        }else {
            result=new Result(0002,"注册失败：系统未知错误");
        }
        return result;
    }



}