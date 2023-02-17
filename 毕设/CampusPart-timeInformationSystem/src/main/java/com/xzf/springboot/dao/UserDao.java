package com.xzf.springboot.dao;

import com.xzf.springboot.pojo.User;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
@Repository
public interface UserDao {

    //查询所有
    List<User> queryUserList();

    //根据id查询
    User queryUserListById(int id);

    //增加用户
    int addUser(User user);

    //更新用户
    int updateUser(User user);

    //删除用户
    int deleteUser(int id);







}
