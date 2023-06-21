package com.springLibrary.service.impl;

import com.springLibrary.persistence.entitiy.Category;
import com.springLibrary.persistence.mapper.CategoryMapper;
import com.springLibrary.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<Category> findAll() {
        return categoryMapper.findAll();
    }
}
