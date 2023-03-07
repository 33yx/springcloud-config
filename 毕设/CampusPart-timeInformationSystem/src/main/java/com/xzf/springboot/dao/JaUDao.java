package com.xzf.springboot.dao;

import com.xzf.springboot.pojo.JaU;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface JaUDao {

//    根据用户名名和订单id查找
    JaU queryList(String uphone,Integer jid);

//    根据用户名查找
    List<JaU> queryByPhone(String uphone);
//    增加
    Integer addJaU(JaU jaU);

    Integer updateJaustatu(JaU jaU);


}
