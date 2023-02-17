package com.xzf.springboot.controller;

import com.xzf.springboot.pojo.User;
import com.xzf.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/yonhu/queryUserList")
    public List<User> queryUserList(){
        List<User> users=userService.queryUserList();

        return users;
    }

    @GetMapping("/yonhu/queryUserListById/{id}")
    public User queryUserListById(@PathVariable int id) {
        User user=userService.queryUserListById(id);
        return user;
    }

    @GetMapping("/yonhu/addUser")
    public String addUser(User user) {
        String s=null;
        int a=userService.addUser(user);
        if (a==1){
            s="增加成功";
        }else {
            s="增加失败";
        }

        return s;
    }

    @GetMapping("/yonhu/updateUser")
    public int updateUser(User user) {
        String s=null;
        int u=userService.updateUser(user);
        if (u==1){
            s= "更新成功";
        }else {
            s= "更新失败";
        }
        return u;
    }

    @GetMapping("/yonhu/deleteUser/{id}")
    public String deleteUser(@PathVariable int id) {
        String s=null;
        int d=userService.deleteUser(id);
        if (d==1){
            s= "删除成功";
        }else {
            s= "删除失败";
        }
        return s;

    }


}
