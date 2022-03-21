package com.service.categoryUser;

import com.model.CategoryUser;
import com.repository.CategoryUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryUserServiceImpl implements CategoryUserService{
@Autowired
private CategoryUserRepository categoryUserRepository;
    @Override
    public List<CategoryUserRepository> findAll() {
        return categoryUserRepository.findAll();
    }

    @Override
    public void saveCategory(CategoryUser categoryUser) {

    }

    @Override
    public void deleteCategory(Long id) {

    }

    @Override
    public CategoryUser findCategoryById(Long id) {
        return null;
    }
}
