package com.atcsc.Mapper;

import com.atcsc.Pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    public int addBlog(Blog blog);

    List<Blog> queryBlogIf(Map map);

    int updateBlog(Map map);

    List<Blog> queryBlogChoose(Map map);

    List<Blog> queryBlogForeach(Map map);
}
