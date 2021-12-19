package dao;

import com.atcsc.Pojo.User;
import com.atcsc.dao.UserMapper;

import com.atcsc.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserMapperTest {

    static Logger logger=Logger.getLogger(UserMapperTest.class);



    @Test
    public void testSelect() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        logger.info("测试，进入getUserList方法成功");
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void testLimit() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startIndex" ,0);
        map.put("pageSize", 3);
        List<User> users = mapper.getUserByLimit(map);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testAdd() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.addUser(new User(6, "小笨", "1524678"));
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testShowAll() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void testUserByBounds() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        int currentPage = 2;
        int pageSize = 2;
        RowBounds rowBounds = new RowBounds((currentPage - 1) * pageSize, pageSize);

        //通过session,** 方法进行传递rowBounds
        List<User> users = sqlSession.selectList("com.atcsc.dao.UserMapper.getUserByRowBound", null, rowBounds);

        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();

    }

    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //使用乐jvm的动态代理
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> allUser = mapper.getAllUser();
        for (User user : allUser) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void testSelectById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.selectUserById(1);
        System.out.println(user);

        sqlSession.close();
    }
}
