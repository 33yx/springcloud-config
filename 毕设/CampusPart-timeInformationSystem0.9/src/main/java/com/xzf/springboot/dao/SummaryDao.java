package com.xzf.springboot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SummaryDao {

    int countUser();
    int countSeller();
    int countJop(Integer examine,Integer valid);
}
