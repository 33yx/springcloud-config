package com.xzf.springboot.service.impl;

import com.xzf.springboot.dao.JopDao;
import com.xzf.springboot.pojo.Jop;
import com.xzf.springboot.service.JopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JopSeviceImpel implements JopService {

    @Autowired
    private JopDao jopDao;




    @Override
    public List<Jop> queryJopList() {
        List<Jop> jopList=null;

        try{
            jopList=jopDao.queryJopList();

        }catch (Exception e){
            jopList=null;
            System.out.println(e);
        }
        return jopList;
    }

    @Override
    public List<Jop> queryqJopList() {
        List<Jop> jopList=null;
       try{
           jopList=jopDao.queryqJopList();
       }catch (Exception e){
        jopList=null;
        System.out.println(e);
       }
        return jopList;
    }

    @Override
    public List<Jop> orderSearchList(Integer input1, String input3) {
        List<Jop> jopList=null;
        Integer examine=1;
        Integer valid=1;
        try{
            jopList=jopDao.orderSearchList(input1,input3,examine,valid);
        }catch (Exception e){
            jopList=null;
            System.out.println(e);
        }
        return jopList;
    }

    @Override
    public List<Jop> queryqJopEnddate() {
        List<Jop> jopList=null;
        try{
            jopList=jopDao.queryqJopEnddate();
        }catch (Exception e){
            jopList=null;
            System.out.println(e);
        }
        return jopList;
    }

    @Override
    public Jop queryjopListById(int id) {
        Jop jop=null;
        try{
            jop=jopDao.queryjopListById(id);
        }catch (Exception e){
            jop=null;
            System.out.println(e);
        }

        return jop;
    }

    @Override
    public Integer updateJopExamine(int jopid, int examine) {
        Integer j=null;
        try{
            j=jopDao.updateJopExamine(jopid,examine);

        }catch (Exception e){
            j=null;
            System.out.println(e);
        }
        return j;
    }

    @Override
    public Integer updateJopNot(int jopid, int examine, String errorreason) {
        Integer j=null;

        try{
            j=jopDao.updateJopNot(jopid,examine,errorreason);

        }catch (Exception e){
            j=null;
            System.out.println(e);
        }
        return j;

    }

    @Override
    public Integer deleteJop(int jopid) {
        Integer d=null;
        try {
            d =jopDao.deleteJop(jopid);
        }catch (Exception e){
            d=null;
            System.out.println(e);
        }

        return d;
    }

    @Override
    public List<Jop> searchJop(String startTime, String endTime, Integer jopid, Integer examine, Integer valid, Integer sellerid) {
        List<Jop> search=null;
        System.out.println("bab alkh"+startTime+","+endTime+","+jopid+","+examine+","+endTime+","+valid+","+sellerid);
        try{
            search=jopDao.searchJop(startTime,endTime,jopid,examine,valid,sellerid);

            System.out.println("sss"+search);
        }catch (Exception e){
            System.out.println(e);
        }

        return search;
    }

    @Override
    public Integer addjop(Jop jop) {
        Integer r=null;
        try{
            r=jopDao.addjop(jop);

        }catch (Exception e){
            r=null;
            System.out.println(e);
        }
        return r;
    }

    @Override
    public Integer changleVaild(Jop jop) {
        Integer j=null;

        try{
            j=jopDao.changleVaild(jop);

        }catch (Exception e){
            j=null;
            System.out.println(e);
        }
        return j;
    }

    @Override
    public Integer updataNumber(Jop jop) {
        Integer n=null;

        try{
            n=jopDao.updataNumber(jop);

        }catch (Exception e){
            n=null;
            System.out.println(e);
        }
        return n;


    }

    @Override
    public List<Jop> queryjopbyphone(String phone) {
        List<Jop> jops=null;
        try {
            jops=jopDao.queryjopbyphone(phone);
        }catch (Exception e){
            jops=null;
            System.out.println(e);
        }

        return jops;
    }
}
