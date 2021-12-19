package com.atcsc.Mapper;


import com.atcsc.Pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {


    @Select("select id, name, pwd from user")
    List<User> getAllUser();

    @Select("select * from user where id=#{id}")
    User selectUserById(@Param("id") int id);

    @Insert("insert into user (id,name,pwd) values (#{id},#{name},#{pwd})")
    int addUser(User user);

    @Update("update user set name=#{name},pwd=#{pwd} where id = #{id}")
    int updateUser(User user);

    //根据id删除用
    @Delete("delete from user where id = #{id}")
    int deleteUser(@Param("id")int id);
}
