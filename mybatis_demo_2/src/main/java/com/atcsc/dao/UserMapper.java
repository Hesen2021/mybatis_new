package com.atcsc.dao;

import com.atcsc.Pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> getUserList();
    int addUser(User user);
    int delUser(int id);
    int updateUser(User user);
    User selectUserById(int id);
}
