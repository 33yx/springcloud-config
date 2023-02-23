package com.xzf.springboot.service.impl;

import com.xzf.springboot.dao.CardDao;
import com.xzf.springboot.dao.SellerDao;
import com.xzf.springboot.pojo.SellerAndCard;
import com.xzf.springboot.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerDao sellerDao;

    @Autowired
    private CardDao cardDao;
    @Override
    public List<SellerAndCard> querySellerList() {
        List<SellerAndCard> sellerAndCard=null;
        try{
           sellerAndCard=sellerDao.querySellerList();
        }catch (Exception e){

            System.out.println(e);
        }

        return sellerAndCard;
    }

    @Override
    public int deleteSeller(int id) {
        Integer a=null;
        Integer b=null;
        String cphone=null;
        try {
            System.out.println("业务层进入");
            cphone=sellerDao.querysellerByphone(id);
            System.out.println("号码为："+cphone);
            a=sellerDao.deleteSeller(id);

            b=cardDao.deleteCard(cphone);
            System.out.println("cars:"+b);

            System.out.println("业务层结果"+cphone+a);
        }catch (Exception e){
            System.out.println(e);
        }
        return a;
    }

    @Override
    public Integer changeSellerStates(Integer state, int id) {
        Integer s=null;
        try {
            s=sellerDao.changeSellerStates(state,id);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }


}
