package com.csc.dao;

import com.csc.Pojo.User;
import com.csc.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();

        for (User user:userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void testAdd() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.addUser(new User(5, "一键三连", "88888"));

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDel() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.delUser(4);
        if(i > 0) {
            System.out.println("删除成功");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserById(3);
        user.setName("小杨");
        user.setPwd("00000");
        mapper.updateUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    //根据密码 和 名字查询用户
    @Test
    public void selectByNameAndPwd() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User u1 = mapper.selectUserByNP("蔡", "123456");
        System.out.println(u1);
        sqlSession.close();
    }

    @Test
    public void selectByNameAndPwd2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", "蔡");
        map.put("pwd", "123456");
        User user = mapper.selectUserByNP2(map);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void selectLike() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectLike("%小%");
        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }

}
