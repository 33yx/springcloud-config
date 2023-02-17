package com.xzf.springboot.dao;

import com.xzf.springboot.pojo.Manager;

import com.xzf.springboot.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface ManagerDao {

    //登陆查询
    Manager queryManagerToLogin(String mphone,String mpassword);

    //查询所有
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
