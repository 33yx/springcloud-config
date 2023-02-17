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
        List<User> userList=userDao.queryUserList();

        return userList;
    }

    @Override
    public User queryUserListById(int id) {
        User user=userDao.queryUserListById(id);
        return user;
    }

    @Override
    public int addUser(User user) {
        int a=userDao.addUser(user);
        return a;
    }

    @Override
    public int updateUser(User user) {
        int u=userDao.updateUser(user);
        return u;
    }

    @Override
    public int deleteUser(int id) {
        int d=userDao.deleteUser(id);
        return d;
    }
}
