package com.springLibrary.service;

import com.springLibrary.persistence.entitiy.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    List<Book> findByNameLike(String keyword);

    void insert(Book book);
}
