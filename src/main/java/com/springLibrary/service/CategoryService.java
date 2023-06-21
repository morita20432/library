package com.springLibrary.service;

import com.springLibrary.persistence.entitiy.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();
}
