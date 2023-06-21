package com.springLibrary.persistence.mapper;

import com.springLibrary.persistence.entitiy.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookMapperTest {

    @Autowired
    BookMapper bookMapper;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    @DisplayName("全件検索した場合、全件が取得できる")
    void findAllTest() {
        List<Book> bookList = bookMapper.findAll();
        assertEquals(12, bookList.size());
    }

    @Test
    @DisplayName("書籍名のキーワードで検索した場合、一致した書籍名を持つ本が取得できる")
    void findByNameLikeTest() {
        List<Book> bookList = bookMapper.findByNameLike("弱虫ペダル");
        assertEquals(6, bookList.size());
    }

    @Test
    @DisplayName("insertメソッドで一件追加した場合、全件数が+1件される")
    void insertTest() {
        Book book = new Book(1,"test",3333);
        bookMapper.insert(book);
        assertEquals(13, JdbcTestUtils.countRowsInTable(jdbcTemplate,"book"));
    }
}

