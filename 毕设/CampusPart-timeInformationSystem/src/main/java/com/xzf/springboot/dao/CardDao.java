package com.xzf.springboot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CardDao {

    public int deleteCard(String cphone);
}
