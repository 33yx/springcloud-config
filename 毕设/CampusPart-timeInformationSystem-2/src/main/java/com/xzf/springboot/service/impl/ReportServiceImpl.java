package com.xzf.springboot.service.impl;

import com.xzf.springboot.dao.ReportDao;
import com.xzf.springboot.pojo.Report;
import com.xzf.springboot.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportDao reportDao;

    @Override
    public List<Report> queryReportList() {
        List<Report> reports=reportDao.queryReportList();
        return reports;
    }

    @Override
    public Report queryReportById(int rid) {
        Report report=reportDao.queryReportById(rid);
        return report;
    }

    @Override
    public int addReport(Report report) {
        int r=0;
        try{
            r=reportDao.addReport(report);
        }catch (Exception e){
            r=0;
            System.out.println("输出的错误为"+e);
        }
        return r;
    }

    @Override
    public Integer updateReport(Report report) {
        Integer s=null;
        try{
            s=reportDao.updateReport(report);
        }catch (Exception e){
            s=null;
            System.out.println("输出的错误为"+e);
        }
        return s;

    }

    @Override
    public int deleteReport(int rid) {
        int d=reportDao.deleteReport(rid);
        return d;
    }

    @Override
    public Integer changeReportStates(Integer state, int rid) {
        return null;
    }

    @Override
    public List<Report> searchReport(String startTime, String endTime, String stats) {
        List<Report> searchReport=null;
        try{

            searchReport = reportDao.searchReport(startTime, endTime,stats);

        }catch (Exception e){
            searchReport=null;
            System.out.println("查询报错为："+e);
        }
        return searchReport;
    }
}
