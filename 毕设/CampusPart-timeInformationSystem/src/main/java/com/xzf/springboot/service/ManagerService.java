package com.xzf.springboot.service;

import com.xzf.springboot.pojo.Manager;

import java.util.List;


public interface ManagerService {

    Manager queryManagerToLogin(String mphone, String mpassword);

    List<Manager> queryManagerList();

    //根据id查询
    Manager queryManagerListById(int id);

    //验证是否重复账号
    Integer queryManagerListByMphone(String mphone);

    //增加
    int addManager(Manager manager);

    //更新
    int updateManager(Manager manager);

    //删除
    int deleteManager(int id);
}
