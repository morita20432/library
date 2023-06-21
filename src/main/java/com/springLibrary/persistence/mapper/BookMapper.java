package com.springLibrary.persistence.mapper;

import com.springLibrary.persistence.entitiy.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {

    @Select("""
            SELECT b.id, b.name, b.price, c.id, c.name
            FROM book b
            JOIN category c ON b.category_id = c.id
            ORDER BY b.id
            """
    )
    List<Book> findAll();

    @Select("""
            SELECT b.id, b.name, b.price, c.id, c.name
            FROM book b
            JOIN category c ON b.category_id = c.id
            WHERE b.name LIKE #{keyword}
            ORDER BY b.id
            """
    )
    List<Book> findByNameLike(String keyword);

    @Insert("""
            INSERT INTO book(id,name,price)
            VALUES(#{id}, #{name}, #{price})
            """
    )
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insert(Book book);
}
