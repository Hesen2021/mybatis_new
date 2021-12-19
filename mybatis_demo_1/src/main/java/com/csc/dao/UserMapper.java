package com.csc.dao;

import com.csc.Pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();
    int addUser(User user);
    int delUser(int id);
    int updateUser(User user);
    User selectUserById(int id);

    User selectUserByNP(@Param("username") String username, @Param("pwd") String pwd);

    User selectUserByNP2(Map<String, Object> map);

    List<User> selectLike(String name);

}
