package com.xzf.springboot.service;

import com.xzf.springboot.pojo.Jop;

import java.util.List;

public interface JopService {

    List<Jop> queryJopList();

    Jop queryjopListById(int id);

    Integer updateJopExamine(int jopid ,int examine);

    Integer updateJopNot(int jopid ,int examine,String errorreason);

    Integer deleteJop(int jopid);

    List<Jop> searchJop(String startTime,String endTime,Integer jopid,Integer examine,Integer valid,Integer  sellerid);

}
