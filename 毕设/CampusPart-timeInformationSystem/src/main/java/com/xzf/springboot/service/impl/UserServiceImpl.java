package com.xzf.springboot.service.impl;

import com.xzf.springboot.dao.UserDao;
import com.xzf.springboot.pojo.User;
import com.xzf.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> queryUserList() {
        List<User> userList=null;

        try{
            userList=userDao.queryUserList();

        }catch (Exception e){
            System.out.println(e);
        }


        return userList;
    }

    @Override
    public User queryUserListById(int id) {
        User user=new User();
        try {
            user =userDao.queryUserListById(id);
        }catch (Exception e){
            System.out.println(e);
        }

        return user;
    }

    @Override
    public int addUser(User user) {

        Integer a=null;
        try {
            a=userDao.addUser(user);
        }catch (Exception e){
            System.out.println(e);
        }

        return a;
    }

    @Override
    public int updateUser(User user) {
        Integer u=null;
        try{
            u=userDao.updateUser(user);
        }catch (Exception e){
            System.out.println(e);
        }

        return u;
    }

    @Override
    public int deleteUser(int id) {
        Integer d=null;
        try {
            d =userDao.deleteUser(id);
        }catch (Exception e){
            System.out.println(e);
        }

        return d;
    }
}
