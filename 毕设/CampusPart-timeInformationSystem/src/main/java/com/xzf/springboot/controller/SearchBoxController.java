package com.xzf.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
                                    Model model,@RequestParam(defaultValue = "1",value = "pageNum")int pageNum
                                   ){
        PageHelper.startPage(pageNum,5);

        System.out.println(start+"____"+end);

        List<Manager> managers = managerService.search(start, end,username);

        PageInfo<Manager> page=new PageInfo<>(managers);

        model.addAttribute("managers",page);
        return "admin-list";

    }
}
