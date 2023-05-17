package com.xzf.springboot.controller;

import com.xzf.springboot.pojo.tool.CountResult;
import com.xzf.springboot.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SummaryController {
    @Autowired
    private SummaryService summaryService;

    //数据统计（welcome页面）
    @GetMapping("/sys/welcome")
    public String welcome(Model model){
        CountResult countResult=null;
        countResult=summaryService.count();
        model.addAttribute("countResult",countResult);
        return "welcome";
    }
}
