package com.xzf.springboot.dao;

import com.xzf.springboot.pojo.Report;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReportDao {

    //查询所有
    List<Report> queryReportList();

    //根据id查询
    Report queryReportById(int rid);

    //增加举报
    int addReport(Report report);

    //写入结果用户
    Integer updateReport(Report report);

    //删除举报
    int deleteReport(int rid);

    //改变转态
    Integer changeReportStates(Integer state,int rid);

    //搜索
    List<Report> searchReport(String startTime,String endTime,String stats);

}
