package com.service.category;

import com.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    void saveCategory(Category category);
    void deleteCategory(Long id );
    Category findCategoryById(Long id);
}
