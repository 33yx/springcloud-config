package com.xzf.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzf.springboot.mongodb.JobDescription;
import com.xzf.springboot.pojo.Jop;
import com.xzf.springboot.pojo.Report;
import com.xzf.springboot.pojo.tool.Result;
import com.xzf.springboot.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Controller
public class ReportController {

    @Autowired
    private ReportService reportService;

    //查询所有
    @GetMapping("/sys/report-list")
    public String queryreportList(Model model, @RequestParam(defaultValue = "1",value = "pageNum")int pageNum){
        String string="";
        List<Report> reports=null;
        PageHelper.startPage(pageNum,5);
        try{
             reports=reportService.queryReportList();
             PageInfo<Report> page=new PageInfo<>(reports);

            model.addAttribute("reports",page);
            string="report-list";
        }catch (Exception e){
            model.addAttribute("erro","载入错误");
            System.out.println(e);
            string="error";
        }

        return string ;
    }

@RequestMapping(value = "/sys/updateReport",produces = "application/json;charset=utf-8",method = RequestMethod.POST)
@ResponseBody
public Result updateReport(@RequestBody Report report) {
    Integer u=null;
    Result result=null;
    report.setState(1);
    System.out.println("值为："+report.getRid()+report.getResult());
    u=reportService.updateReport(report);


    if (u==1){
        result=new Result(0001,"处理完成");
    }else {
        result=new Result(0003,"处理失败");
    }

    return result;
}
    @GetMapping("/sys/reportchuli/{rid}")
    public String toEdit( @PathVariable("rid") Integer rid,Model model){
    Report report = reportService.queryReportById(rid);

    model.addAttribute("report",report);
    return "report-edit";
}

    @GetMapping("/sys/deleteReport")
    @ResponseBody
    public Result deleteReport(int rid) {
        String s=null;
        int d=0;
        Result result=null;
        try {
            d=reportService.deleteReport(rid);
        }catch (Exception e){
            System.out.println(e);
        }
        if (d!=0){
            result=new Result(0001,"删除成功");
        }else{
            result=new Result(0002,"删除失败");
        }
        return result;

    }

    //    //批量删除
    @GetMapping("/sys/delaAllReport")
    @ResponseBody
    public Result delBatch(String rids) {
        Result result=null;
        int d=0;
        String [] ridlist=rids.split(",");
        try {
            for (int i=0;i<ridlist.length;i++){
                if (ridlist[i].equals("1")){
                    System.out.println("错误");
                    d=1314520;
                    break;

                }else {
                    d=reportService.deleteReport(Integer.parseInt(ridlist[i]));
                    d+=1;
                }
            }
            if (d!=0){
                result=new Result(0001,"删除成功");
            }else{
                result=new Result(0002,"删除失败");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return result;

    }

    //添加举报
    @PostMapping("/fore/addReport")
    @ResponseBody
    public Result addReport(Report report){
        Result result=null;
        int r=0;



//        report.setReporterName(reporterName);
        System.out.println("jjj:"+report);
//        report.setReportOrdersId(reportOrdersId);
//        report.setReason(reason);
        report.setState(0);
        Timestamp d = new Timestamp(System.currentTimeMillis());
        report.setTime(d);
        System.out.println("fff4444:"+report);
//
         r=reportService.addReport(report);
        System.out.println("ggg:"+r);
        if (r==1){
            result=new Result(0001,"提交成功");
        }else {
            result=new Result(0002,"提交失败");
        }


        return result;
    }

}
