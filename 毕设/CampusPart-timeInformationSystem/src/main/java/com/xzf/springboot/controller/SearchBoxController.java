package com.xzf.springboot.controller;

import com.xzf.springboot.pojo.Manager;
import com.xzf.springboot.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.crypto.Data;
import java.util.List;

@Controller
public class SearchBoxController {
    @Autowired
    private ManagerService managerService;

   //管理员搜索
    @RequestMapping("/sys/search")
    public String queryManagerList(@RequestParam("start") String start,
                                   @RequestParam("end") String end,
                                   @RequestParam("username") String username,
                                    Model model
                                   ){

        System.out.println(start+"____"+end);

        List<Manager> managers = managerService.search(start, end,username);

        model.addAttribute("managers",managers);
        return "admin-list";

    }
}
