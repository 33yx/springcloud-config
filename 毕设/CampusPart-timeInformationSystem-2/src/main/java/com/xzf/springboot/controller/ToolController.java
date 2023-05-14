package com.xzf.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToolController {

    @GetMapping("/sys/echarts1")
    public String toEcharts1(){
        return "echarts1";
    }
}
