package com.xzf.springboot.service.impl;

import com.xzf.springboot.dao.ManagerDao;
import com.xzf.springboot.pojo.Manager;
import com.xzf.springboot.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public int addManager(Manager manager) {
        int a=managerDao.addManager(manager);
        return a;
    }

    @Override
    public int updateManager(Manager manager) {
        int u=managerDao.updateManager(manager);
        return u;
    }

    @Override
    public int deleteManager(int id) {
        int d=managerDao.deleteManager(id);
        return d;
    }
}
