package com.xzf.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToolController {

    @GetMapping("/sys/echarts1")
    public String toEcharts1(){
        return "echarts1";
    }

    @GetMapping("/sys/echarts3")
    public String toEcharts3(){
        return "echarts1";
    }

    @GetMapping("/sys/echarts4")
    public String toEcharts4(){
        return "echarts4";
    }

    @GetMapping("/sys/echarts5")
    public String toEcharts5(){
        return "echarts5";
    }

    @GetMapping("/sys/echarts6")
    public String toEcharts6(){
        return "echarts6";
    }

    @GetMapping("/sys/echarts7")
    public String toEcharts7(){
        return "echarts7";
    }

    @GetMapping("/sys/echarts8")
    public String toEcharts8(){
        return "echarts8";
    }

    @GetMapping("/sys/unicode")
    public String toUnicode(){
        return "unicode";
    }

    @GetMapping("/sys/demo")
    public String toDemo(){
        return "demo";
    }



}
