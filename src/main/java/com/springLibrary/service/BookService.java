package com.springLibrary.service;

import com.springLibrary.persistence.entitiy.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    List<Book> findAll();

    List<Book> findByNameLike(String keyword);

    void insert(Book book);
}
