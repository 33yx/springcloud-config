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
import org.springframework.web.bind.annotation.*;
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
//            System.out.println(page);
            return "member-list";

        }else {
            model.addAttribute("erro","载入错误");
            return "error";
        }
    }

    //增加
    @PostMapping("/sys/toUserList")
    @ResponseBody
    public Result addUser(int uid,String username,String uname,int uage,String schooll,String studentid,String cardid,String usex,String phone, String address,String email,String pass){
        Result result=null;
        User user=new User();
        int u=0;

        Integer i=userService.queryUserListByphone(phone);

        System.out.println("判断是否存在"+i);
        if (i==null){
            System.out.println("进入赋值");
            user.setId(uid);
            user.setUsename(username);
            user.setUname(uname);
            user.setUseage(uage);
            user.setSchoollname(schooll);
            user.setStudentid(studentid);
            user.setStatus(1);
            user.setCardid(cardid);
            user.setUsex(usex);
            user.setPhone(phone);
            user.setAddress(address);
            user.setUemail(email);
            user.setPassword(pass);
            u=userService.addUser(user);

            System.out.println("是否有进行查询："+u);
        }else {
            result=new Result(0002,"增加失败："+i+"账号已经存在");
        }


        if(u==1){
            result=new Result(0001,"增加成功");
        }else {
            result=new Result(0003,"系统未知错误，增加失败");
        }



        return result;
    }


    //批量删除
    @GetMapping("/sys/userdelall")
    @ResponseBody
    public Result userDelallall(String uids){
        Result result=null;
        Integer d=0;
        Integer s=0;
        String [] uidlist=uids.split(",");
        for (int i=0;i<uidlist.length;i++){
            d=userService.deleteUser(Integer.parseInt(uidlist[i]));
            s+=d;
        }

        if (s!=0 && s!=null){
            result=new Result(0001,"删除成功，共删除"+s+"条");
        }else{
            result=new Result(0002,"删除失败");
        }
        return result;
    }

    //到修改界面
    @GetMapping("/sys/member-edit/{uid}")
    public String toUserEdit(@PathVariable("uid") Integer uid,Model model){

        User user=userService.queryUserListById(uid);

        if (!StringUtils.isEmpty(String.valueOf(user))){

            model.addAttribute("userd",user);
            return "member-edit";
        }else {
            return "error";
        }

    }


    //修改
    @RequestMapping(value = "/sys/userUpdate",produces = "application/json;charset=utf-8",method = RequestMethod.POST)
//    @PostMapping("/sys/userUpdate")
    @ResponseBody
    public Result userUpdate(@RequestBody User user){
        Integer u=null;
        Result result=null;


        u=userService.updateUser(user);
        System.out.println("修改后为"+u);

        if (u==1){
            result=new Result(0001,"修改成功");
        }else {
            result=new Result(0003,"修改失败");
        }

        return result;
    }

    //删除
    @GetMapping("/sys/userDelete")
    @ResponseBody
    public Result userDelete(int id){
        int d=0;
        Result result=null;

        d=userService.deleteUser(id);
        if (d!=0){
            result=new Result(0001,"删除成功");
        }else{
            result=new Result(0002,"删除失败");
        }
        return result;
    }

    //修改，赋予转态
    @PostMapping("/sys/changeUserStates")
    public String changeUserStates(Integer state,int uid){
        Result result = null;
        String string=null;

        Integer i=userService.changeUserStates(state,uid);
        if (i==1){
//            result=new Result(0001,"成功");
            string="redirect:/sys/member-list";
        }else {
//            result=new Result(0002,"失败");
            string="/sys/error";
        }

        return string;
    }

}
