package com.example.demo.mapper;

import com.example.demo.pojo.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginMapper {
@Select("SELECT phone,password FROM `user` WHERE phone=#{phone} AND password=#{password}")
    User findByUsernameAndPassword(@Param("phone") String phone, @Param("password") String password);

}
