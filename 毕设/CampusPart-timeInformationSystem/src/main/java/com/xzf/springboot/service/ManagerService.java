package com.xzf.springboot.service;

import com.xzf.springboot.pojo.Manager;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ManagerService {

    Manager queryManagerToLogin(String mphone, String mpassword);

    List<Manager> queryManagerList();

    //根据id查询
    Manager queryManagerListById(int id);

    //增加
    int addManager(Manager manager);

    //更新
    int updateManager(Manager manager);

    //删除
    int deleteManager(int id);
}
