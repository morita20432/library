package com.springLibrary.service;

import com.springLibrary.persistence.entitiy.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    List<Category> findAll();
}
