package com.ung_dung_blog2.service.blog;

import com.ung_dung_blog2.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);
    void saveBlog(Blog blog);
    void deleteBlog(Long id );
    Blog findBlogById(Long id);
    Page<Blog> findByName(String name, Pageable pageable);
}
