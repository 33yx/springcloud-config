package com.xzf.springboot.service.impl;

import com.xzf.springboot.dao.CardDao;
import com.xzf.springboot.dao.SellerDao;
import com.xzf.springboot.pojo.Card;
import com.xzf.springboot.pojo.Seller;
import com.xzf.springboot.pojo.SellerAndCard;
import com.xzf.springboot.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.valueOf;

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

    @Override
    public Integer querySellertAndCardByphone(String sphone) {

        String card=null;
        Integer id=null;

        Integer s=null;
        try {
            card=cardDao.querycard(sphone);
            id=sellerDao.querySellertByphone(sphone);

        }catch (Exception e){
            System.out.println(e);
        }
        if (card==null & id==null){
            s=0001;//账号不存在，能增加
            return s;
        }else if (id !=null & card ==null) {
            s=0002;//该账号已经存在但未绑定身份证
        }else {
            s=0003;//账号已经存在
        }


        return null;
    }

    @Override
    public void addSeller(Seller seller, Card card) {
        Integer a=null;
        try {
            System.out.println("开始今天");
            a=sellerDao.addSeller(seller);
            System.out.println("插入操作"+a);
            cardDao.addCard(card);
        }catch (Exception e){
            System.out.println(e);
        }





    }

    @Override
    public SellerAndCard querySellerListById(int id) {
        Seller seller=null;
        Card card=null;
        SellerAndCard SAC=new SellerAndCard();

        try {

            seller=sellerDao.queryssellerById(id);
            card=cardDao.querycardone(seller.getSphone());

            SAC.setSellerid(seller.getSellerid());
            SAC.setSname(seller.getSname());
            SAC.setSaddress(seller.getSaddress());
            SAC.setBusinesslicense(seller.getBusinesslicense());
            SAC.setSphone(seller.getSphone());
            SAC.setSpasswoed(seller.getSpasswoed());
            SAC.setSstatus(seller.getSstatus());
            SAC.setSsex(seller.getSsex());
            SAC.setSemail(seller.getSemail());
            SAC.setCarid(card.getCarid());
            SAC.setCname(card.getCname());
            SAC.setCage(card.getCage());


        }catch (Exception e){
            System.out.println(e);
        }



        return SAC;
    }

    @Override
    public int updataSellerAC(SellerAndCard SaC) {
        Seller seller=new Seller();
        Card card=new Card();
        Integer s=null;
        Integer c=null;
        Integer r=null;

        seller.setSellerid(SaC.getSellerid());
        seller.setSname(SaC.getSname());
        seller.setSaddress(SaC.getSaddress());
        seller.setSphone(SaC.getSphone());
        seller.setSpasswoed(SaC.getSpasswoed());
        seller.setSstatus(SaC.getSstatus());
        seller.setSsex(SaC.getSsex());
        seller.setSemail(SaC.getSemail());
        seller.setBusinesslicense(SaC.getBusinesslicense());

        card.setCarid(SaC.getCarid());
        card.setCname(SaC.getCname());
        card.setCage(SaC.getCage());
        card.setCphone(SaC.getSphone());

        try{
           s=sellerDao.updateSeller(seller);
            c=cardDao.updateCard(card);

            if (s==1 & c==1){
                r=1;//两张表都有修改
            }else{
                r=5;//未知系统错误
            }
        }catch (Exception e){
            r=5;
            System.out.println("输出的错误为"+e);
        }



        return r;
    }

    @Override
    public List<SellerAndCard> searchSeller(String sname, String sphone) {

        List<SellerAndCard> sellers=null;
        try {
            sellers=sellerDao.searchSeller(sname,sphone);

        }catch (Exception e){
            sellers=null;
            System.out.println(e);
        }

        return sellers;
    }


}
