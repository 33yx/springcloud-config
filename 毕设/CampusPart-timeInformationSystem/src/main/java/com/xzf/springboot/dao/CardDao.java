package com.xzf.springboot.dao;

import com.xzf.springboot.pojo.Card;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CardDao {

    public int deleteCard(String cphone);

    public String querycard(String cphone);

    public Integer addCard(Card card);

    public Card querycardone(String cphone);

    public Integer updateCard(Card card);


}
