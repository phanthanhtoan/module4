package com.service.categoryUser;

import com.model.CategoryUser;
import com.repository.CategoryUserRepository;

import java.util.List;

public interface CategoryUserService {
    List<CategoryUserRepository> findAll();
    void saveCategory(CategoryUser categoryUser);
    void deleteCategory(Long id );
    CategoryUser findCategoryById(Long id);
}
