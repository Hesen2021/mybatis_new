package com.atcsc.Mapper;

import com.atcsc.Pojo.Blog;
import com.atcsc.utils.IdUtils;
import com.atcsc.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class MapperTest {

    @Test
    public void initBlot() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        mapper.addBlog(new Blog(IdUtils.genId(), "如何考上研究神", "hesen", new Date(), 22333));
        mapper.addBlog(new Blog(IdUtils.genId(), "如何开始机器学习", "hesen", new Date(), 11333));
        mapper.addBlog(new Blog(IdUtils.genId(), "如何发表Nature", "hesen", new Date(), 22444));
        mapper.addBlog(new Blog(IdUtils.genId(), "如何称为卷王", "hesen", new Date(), 33333));


        sqlSession.close();
    }

    @Test
    public void initBlot2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        mapper.addBlog(new Blog(IdUtils.genId(), "如何进行社会学研究", "hesen", new Date(), 22333));


        sqlSession.close();
    }

    @Test
    public void testIf() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, Object> map = new HashMap<>();

        map.put("title", "如何开始机器学习");
//        map.put("author", "lyang");

        List<Blog> blogs = mapper.queryBlogIf(map);
        System.out.println(blogs.toString());

        sqlSession.close();
    }

    @Test
    public void testWhere() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, Object> map = new HashMap<>();
//        map.put("title", "如何开始机器学习");
        map.put("author", "lyang");//这次不会报错了

        List<Blog> blogs = mapper.queryBlogIf(map);
        System.out.println(blogs.toString());

        sqlSession.close();
    }

    @Test
    public void testSet() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Map<String, Object> map = new HashMap<>();
        map.put("id", "6623e0793fcc4e9281d1e802454e4701");
        map.put("title", "机器学习从入门到放弃");

        mapper.updateBlog(map);
        sqlSession.close();
    }

    @Test
    public void testBlog() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Map<String, Object> map = new HashMap<>();
        map.put("title", "如何考上研究神");
        map.put("author", "lyang");
        map.put("views", 11333);
        List<Blog> blogs = mapper.queryBlogChoose(map);
        System.out.println(blogs);

        sqlSession.close();
    }

    @Test
    public void testQueryBlogForeach() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        ids.add(4);
        map.put("ids", ids);

        List<Blog> blogs = mapper.queryBlogForeach(map);
        System.out.println(blogs);

        sqlSession.close();
    }


}
