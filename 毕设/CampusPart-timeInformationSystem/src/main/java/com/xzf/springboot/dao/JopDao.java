package com.xzf.springboot.dao;

import com.xzf.springboot.pojo.Jop;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface JopDao {

    //查询所有
     List<Jop> queryJopList();


     List<Jop> queryqJopList();


    List<Jop> queryqJopEnddate();
     //根据id查询
    Jop queryjopListById(int id);

    //根据发布者查找
    List<Jop> queryjopbyphone(String phone);

    //审核通过
    Integer updateJopExamine(int jopid ,int examine);
    //审核不通过
    Integer updateJopNot(int jopid ,int examine,String errorreason);

    //删除
    int deleteJop(int jopid);

    //搜索框
    List<Jop> searchJop(String startTime,String endTime,Integer jopid,Integer examine,Integer valid,Integer  sellerid);

    Integer addjop(Jop jop);

    Integer changleVaild(Jop jop);

    Integer updataNumber(Jop jop);
}
