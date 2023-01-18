package com.example.demo.service;



import com.example.demo.mapper.LoginMapper;
import com.example.demo.pojo.User;
import com.example.demo.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private LoginMapper loginMapper;
    @Override
    public User findByUsernameAndPassword(String phone, String password) {
        User user = loginMapper.findByUsernameAndPassword(phone, MD5Utils.code(password));
        return user;
    }
}
