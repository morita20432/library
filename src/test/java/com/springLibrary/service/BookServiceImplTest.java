package com.springLibrary.service;

import com.springLibrary.persistence.entitiy.Book;
import com.springLibrary.persistence.mapper.BookMapper;
import com.springLibrary.service.impl.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BookServiceImplTest {

    BookService bookService;
    BookMapper bookMapper;

    @BeforeEach
    void setUp() {
        bookMapper = mock(BookMapper.class);
        bookService = new BookServiceImpl(bookMapper);
    }

    @Test
    @DisplayName("findAllで全件取得")
    void findAllTest() {
        when(bookMapper.findAll()).thenReturn(List.of(
                new Book(1, "弱虫ペダル1", 500),
                new Book(2, "弱虫ペダル2", 500),
                new Book(3, "弱虫ペダル3", 500)
        ));

        List<Book> bookList = bookService.findAll();
        assertEquals(3, bookList.size());
        verify(bookMapper, times(1)).findAll();
    }

    @Test
    @DisplayName("findByNameLikeで一致した本を取得")
    void findByNameLikeTest() {
        when(bookMapper.findAll()).thenReturn(List.of(
                new Book(1, "弱虫ペダル1", 500),
                new Book(2, "弱虫ペダル2", 500),
                new Book(3, "弱虫ペダル3", 500)
        ));

        List<Book> bookList = bookService.findByNameLike("弱虫ペダル");
        assertEquals(3, bookList.size());
        verify(bookMapper, times(1)).findAll();
    }
}
