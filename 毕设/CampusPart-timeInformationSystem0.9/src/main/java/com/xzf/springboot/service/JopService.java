package com.xzf.springboot.service;

import com.xzf.springboot.pojo.Jop;

import java.util.List;

public interface JopService {

    List<Jop> queryJopList();

    List<Jop> queryqJopList();

    List<Jop> orderSearchList(Integer input1,String input3);

    List<Jop> queryqJopEnddate();

    Jop queryjopListById(int id);

    Integer updateJopExamine(int jopid ,int examine);

    Integer updateJopNot(int jopid ,int examine,String errorreason);

    Integer deleteJop(int jopid);

    List<Jop> searchJop(String startTime,String endTime,Integer jopid,Integer examine,Integer valid,Integer  sellerid);

    Integer addjop(Jop jop);


    Integer changleVaild(Jop jop);

    Integer updataNumber(Jop jop);

    List<Jop> queryjopbyphone(String phone);

}
