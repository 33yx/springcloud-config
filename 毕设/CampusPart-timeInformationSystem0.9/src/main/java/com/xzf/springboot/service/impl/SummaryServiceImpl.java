package com.xzf.springboot.service.impl;

import com.xzf.springboot.dao.SummaryDao;
import com.xzf.springboot.pojo.tool.CountResult;
import com.xzf.springboot.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SummaryServiceImpl implements SummaryService {
    @Autowired
    private SummaryDao summaryDao;

    public CountResult count(){
        CountResult countResult=new CountResult();
        Integer countUser=null;
        Integer countSeller=null;
        Integer countJop=null;
        Integer countJopw=null;
        Integer countJopok=null;
        Integer countJopnot=null;
        try{
            countUser=summaryDao.countUser();
            countSeller=summaryDao.countSeller();
            countJop=summaryDao.countJop(null,null);
            countJopw=summaryDao.countJop(null,0);
            countJopok=summaryDao.countJop(1,1);
            countJopnot=summaryDao.countJop(0,1);
            countResult.setId(1);
            countResult.setCountUser(countUser);
            countResult.setCountSeller(countSeller);
            countResult.setCountJop(countJop);
            countResult.setCountJopw(countJopw);
            countResult.setCountJopok(countJopok);
            countResult.setCountJopnot(countJopnot);
        }catch (Exception e){
            System.out.println("123");
            countResult.setId(2);
            System.out.println(e);
        }
      return countResult;
    }
}
