package com.atcsc.dao;

import com.atcsc.Pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> getUserList();
    int addUser(User user);
    int delUser(int id);
    int updateUser(User user);
    List<User> getUserByLimit(Map<String, Object> map);
    List<User> getUserByRowBound();

    @Select("select id, name, pwd from user")
    List<User> getAllUser();

    @Select("select * from user where id=#{id}")
    User selectUserById(@Param("id") int id);
}
