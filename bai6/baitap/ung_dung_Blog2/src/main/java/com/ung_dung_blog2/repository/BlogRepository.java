package com.ung_dung_blog2.repository;

import com.ung_dung_blog2.model.Blog;
import com.ung_dung_blog2.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findByNameContaining(String name, Pageable pageable);
}
