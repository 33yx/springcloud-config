package com.xzf.springboot.controller;

import com.xzf.springboot.pojo.Manager;
import com.xzf.springboot.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    //查询所有




    @GetMapping("/sys/admin-list")
    public String queryManagerList(Model model){
        List<Manager> managers=managerService.queryManagerList();
        System.out.println(managers);
        model.addAttribute("managers",managers);
        return "admin-list";
     }

    public Manager queryManagerListById(@RequestParam("id") int id){
        Manager manager=managerService.queryManagerListById(id);

        return manager;
    }


    public int addManager(Manager manager) {
        int a=managerService.addManager(manager);
        return a;
    }


    public int updateManager(Manager manager) {
        int u=managerService.updateManager(manager);
        return u;
    }


    public int deleteManager(int id) {
        int d=managerService.deleteManager(id);
        return d;
    }
}
