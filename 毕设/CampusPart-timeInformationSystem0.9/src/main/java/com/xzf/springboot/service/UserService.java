package com.xzf.springboot.service;

import com.xzf.springboot.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    List<User> queryUserList();

    User queryUserListById(int id);

    //根据phone查询
    Integer queryUserListByphone(String phone);

    int addUser(User user);

    //更新用户
    int updateUser(User user);

    //删除用户
    Integer deleteUser(int id);

    //改变转态
    Integer changeUserStates(Integer state,int id);

    User queryUserToLogin(String phone,String password);



}
