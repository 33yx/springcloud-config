package com.example.demo.service;

import com.example.demo.pojo.User;

public interface UserService {
    User findByUsernameAndPassword(String phone,String password);
}
