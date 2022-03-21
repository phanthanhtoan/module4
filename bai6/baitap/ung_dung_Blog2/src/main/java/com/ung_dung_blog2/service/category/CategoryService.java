package com.ung_dung_blog2.service.category;

import com.ung_dung_blog2.model.Category;
import com.ung_dung_blog2.model.Category;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    void saveCategory(Category category);
    void deleteCategory(Long id );
    Category findCategoryById(Long id);
}
