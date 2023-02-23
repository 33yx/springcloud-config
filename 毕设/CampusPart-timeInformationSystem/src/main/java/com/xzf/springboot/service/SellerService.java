package com.xzf.springboot.service;


import com.xzf.springboot.pojo.SellerAndCard;

import java.util.List;

public interface SellerService {
    //查询所有
    List<SellerAndCard> querySellerList();

    int deleteSeller(int id);

    Integer changeSellerStates(Integer state,int id);



}
