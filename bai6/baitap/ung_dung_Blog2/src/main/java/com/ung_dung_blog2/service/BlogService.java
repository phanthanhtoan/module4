package com.ung_dung_blog2.service;

import com.ung_dung_blog2.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    void saveBlog(Blog blog);
    void deleteBlog(Long id );
    Blog findBlogById(Long id);
}
