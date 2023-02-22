package com.xzf.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzf.springboot.pojo.Manager;
import com.xzf.springboot.pojo.Result;
import com.xzf.springboot.pojo.User;
import com.xzf.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import java.util.List;


@Controller
public class StudentController {

//    @GetMapping("/sys/member-list1")
//    public String studentList1(){
//        System.out.println("进入目的地");
//
//        return "member-list1";
//    }

    @Autowired
    private UserService userService;

    @GetMapping("/sys/member-list")
    public String studentList(Model model,@RequestParam(defaultValue = "1",value = "pageNum")int pageNum){

        PageHelper.startPage(pageNum,5);

        List<User> users = userService.queryUserList();

        if (!StringUtils.isEmpty(String.valueOf(users))){
            PageInfo<User> page=new PageInfo<>(users);
            model.addAttribute("users",page);
            System.out.println(page);
            return "member-list";

        }else {
            model.addAttribute("erro","载入错误");
            return "error";
        }
    }


    @GetMapping("/sys/userdelall")
    @ResponseBody
    public Result userDelallall(String uids){
        Result result=null;
        int d=0;
        String [] uidlist=uids.split(",");
        for (int i=0;i<uidlist.length;i++){
            d=userService.deleteUser(Integer.parseInt(uidlist[i]));
            d+=1;
        }

        if (d!=0){
            result=new Result(0001,"删除成功");
        }else{
            result=new Result(0002,"删除失败");
        }
        return result;
    }
}
