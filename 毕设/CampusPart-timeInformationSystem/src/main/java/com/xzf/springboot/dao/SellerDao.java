package com.xzf.springboot.dao;


import com.xzf.springboot.pojo.Seller;
import com.xzf.springboot.pojo.SellerAndCard;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SellerDao {

    //查询所有
    List<SellerAndCard> querySellerList();

    //删除商家
    int deleteSeller(int sellerid);

    String querysellerByphone(int sellerid);

    Integer changeSellerStates(Integer sstatus,int sellerid);

    //通过手机号查找id
    Integer querySellertByphone(String sphone);


    //增加
    int addSeller(Seller seller);

    Seller queryssellerById(int sellerid);

    Integer updateSeller(Seller seller);


}
