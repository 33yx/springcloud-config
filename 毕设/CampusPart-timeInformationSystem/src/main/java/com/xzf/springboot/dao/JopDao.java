package com.xzf.springboot.dao;

import com.xzf.springboot.pojo.Jop;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface JopDao {

    //查询所有
     List<Jop> queryJopList();

     //根据id查询
    Jop queryjopListById(int id);

    //审核通过
    Integer updateJopExamine(int jopid ,int examine);
    //审核不通过
    Integer updateJopNot(int jopid ,int examine,String errorreason);

    //删除
    int deleteJop(int jopid);

    //搜索框
    List<Jop> searchJop(String startTime,String endTime,Integer jopid,Integer examine,Integer valid,Integer  sellerid);
}
