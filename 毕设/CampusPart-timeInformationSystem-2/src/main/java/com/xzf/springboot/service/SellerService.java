package com.xzf.springboot.service;


import com.xzf.springboot.pojo.Card;
import com.xzf.springboot.pojo.Seller;
import com.xzf.springboot.pojo.SellerAndCard;

import java.util.List;

public interface SellerService {
    //查询所有
    List<SellerAndCard> querySellerList();

    int deleteSeller(int id);

    Integer changeSellerStates(Integer state,int id);

    Integer querySellertAndCardByphone(String sphone);

    void addSeller(Seller seller, Card card);


    SellerAndCard querySellerListById(int id);

    int updataSellerAC(SellerAndCard sellerAndCard);

    List<SellerAndCard> searchSeller(String sname,String sphone);



    Seller querySellerToLogin(String phone,String password);

    SellerAndCard sellerall(String phone,String password);

    Integer querySellertByphone(String phone);



}
