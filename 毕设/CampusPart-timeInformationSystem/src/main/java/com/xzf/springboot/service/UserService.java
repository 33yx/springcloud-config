package com.xzf.springboot.service;

import com.xzf.springboot.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    List<User> queryUserList();

    User queryUserListById(int id);

    int addUser(User user);

    //更新用户
    int updateUser(User user);

    //删除用户
    int deleteUser(int id);




}
