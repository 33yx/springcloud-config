package com.xzf.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzf.springboot.dao.ManagerDao;
import com.xzf.springboot.pojo.Manager;
import com.xzf.springboot.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerSeviceImpl implements ManagerService {
    @Autowired
    private ManagerDao managerDao;

    @Override
    public Manager queryManagerToLogin(String mphone, String mpassword) {
        Manager manager=managerDao.queryManagerToLogin(mphone,mpassword);
        return manager;
    }

    @Override
    public List<Manager> queryManagerList() {
        List<Manager> managers=managerDao.queryManagerList();
        return managers;
    }

    @Override
    public PageInfo splitPage() {
        PageHelper.startPage(1,5);
        List<Manager> list=null;
        try{
           list = managerDao.queryManagerList();
        }catch (Exception e){
            System.out.println(e);
        }

        return new PageInfo<>(list);
    }

    @Override
    public Manager queryManagerListById(int id) {
        Manager manager=managerDao.queryManagerListById(id);
        return manager;
    }

    //验证是否重复账号
    @Override
    public Integer queryManagerListByMphone(String mphone) {

        Integer managerid=managerDao.queryManagerListByMphone(mphone);
        return managerid;
    }

    @Override
    public List<Manager> search(String startTime, String endTime,String userName) {
        List<Manager> search=null;
        try{
            System.out.println("开始进入搜索");
            search = managerDao.search(startTime, endTime,userName);
            System.out.println("搜索结果为："+search);
        }catch (Exception e){
            System.out.println("查询报错为："+e);
        }
        return search;
    }

    @Override
    public int addManager(Manager manager) {
        int a=managerDao.addManager(manager);
        return a;
    }

    @Override
    public Integer updateManager(Manager manager) {
        Integer u=null;
        try{
            u=managerDao.updateManager(manager);

        }catch (Exception e){
            System.out.println(e);
        }
        return u;
    }

    @Override
    public int deleteManager(int id) {
        int d=managerDao.deleteManager(id);
        return d;
    }

    @Override
    public Integer changeState(Integer state,int id) {
        Integer s=null;
        try {
            s=managerDao.changeState(state,id);
        }catch (Exception e){
            System.out.println(e);
        }
        return s;
    }
}
