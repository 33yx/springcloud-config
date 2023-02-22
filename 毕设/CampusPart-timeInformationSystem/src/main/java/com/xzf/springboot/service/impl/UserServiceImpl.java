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
    public Integer queryUserListByphone(String phone) {
        Integer p=-66;
        try{
        p= userDao.queryUserListByphone(phone);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
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
            System.out.println("进入修改");
            u=userDao.updateUser(user);
            System.out.println("ser层修改后"+u);
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

    @Override
    public Integer changeUserStates(Integer state, int id) {
        Integer s=null;
        try {
            s=userDao.changeUserStates(state,id);
        }catch (Exception e){
            System.out.println(e);
        }
        return s;
    }
}
