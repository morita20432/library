package com.springLibrary.persistence.mapper;

import com.springLibrary.persistence.entitiy.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Select("""
            SELECT *
            FROM category c
            ORDER BY c.id
            """)
    List<Category> findAll();
 }
