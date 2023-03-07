package com.xzf.springboot.service;

import com.xzf.springboot.pojo.JaU;

import java.util.List;

public interface JaUService {
    //    根据用户名名和订单id查找
    JaU queryList(String uphone, Integer jid);

    //    根据用户名查找
    List<JaU> queryByPhone(String uphone);
    //    增加
    Integer addJaU(JaU jaU);

    Integer updateJaustatu(JaU jaU);

}
