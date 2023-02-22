package com.xzf.springboot.service;

import com.github.pagehelper.PageInfo;
import com.xzf.springboot.pojo.Manager;

import java.util.List;


public interface ManagerService {

    Manager queryManagerToLogin(String mphone, String mpassword);

    List<Manager> queryManagerList();

    //分页查询
    PageInfo splitPage();

    //根据id查询
    Manager queryManagerListById(int id);

    //验证是否重复账号
    Integer queryManagerListByMphone(String mphone);

    //查询
    List<Manager> search(String startTime,String endTime,String userName);

    //增加
    int addManager(Manager manager);

    //更新
    Integer updateManager(Manager manager);

    //删除
    int deleteManager(int id);

    //改变状态
    Integer changeState(Integer state,int id);

}
