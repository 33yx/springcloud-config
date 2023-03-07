package com.xzf.springboot.service.impl;

import com.xzf.springboot.dao.JaUDao;
import com.xzf.springboot.pojo.JaU;
import com.xzf.springboot.service.JaUService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JaUServiceImpel implements JaUService {

    @Autowired
    private JaUDao jaUDao;

    @Override
    public JaU queryList(String uphone, Integer jid) {
        JaU jaU=null;
        try{

            jaU=jaUDao.queryList(uphone,jid);

        }catch (Exception e){
            jaU=null;
            System.out.println(e);
        }

        return jaU;
    }

    @Override
    public List<JaU> queryByPhone(String uphone) {
        List<JaU> jaUS=null;
        try{
            jaUS=jaUDao.queryByPhone(uphone);
        }catch (Exception e){
            jaUS=null;
            System.out.println(e);
        }

        return jaUS;
    }

    @Override
    public Integer addJaU(JaU jaU) {
        Integer a=null;
        try{
            a=jaUDao.addJaU(jaU);

        }catch (Exception e){
           a=null;
            System.out.println(e);
        }


        return a;
    }

    @Override
    public Integer updateJaustatu(JaU jaU) {

        Integer r=null;
        try{
            r=jaUDao.updateJaustatu(jaU);
        }catch (Exception e){
            r=null;
            System.out.println(e);
        }
        return r;
    }
}
