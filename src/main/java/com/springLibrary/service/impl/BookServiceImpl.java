package com.springLibrary.service.impl;

import com.springLibrary.persistence.entitiy.Book;
import com.springLibrary.persistence.mapper.BookMapper;
import com.springLibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> findAll() {
        return bookMapper.findAll();
    }

    @Override
    @Transactional(readOnly = true)

    public List<Book> findByNameLike(String keyword) {
        return bookMapper.findByNameLike(keyword);
    }

    @Override
    public void insert(Book book) {
        bookMapper.insert(book);
    }
}
