package com.springLibrary.web.controller;

import com.springLibrary.service.BookService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class BookControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    BookService bookService;

//    @Nested
//    class findAll {
//        final MockHttpServletRequestBuilder requestBuilder = get("/").accept(MediaType.TEXT_HTML);
//
//
//        @Test
//        @DisplayName("全件検索")
//        void findAllTest() throws Exception {
//            mvc.perform(requestBuilder)
//                    .andExpect(status().isOk())
//                    .andExpect(view().name("index"));
//        }
//
//        @Test
//        @DisplayName("名前一致検索")
//        void findByNameLikeTest() throws Exception {
//            mvc.perform(requestBuilder)
//                    .andExpect(status().isOk())
//                    .andExpect(view().name("index"));
//        }
//    }
//
//    class insert {
//        final MockHttpServletRequestBuilder requestBuilder = get("/insertMain")
//                .accept(MediaType.TEXT_HTML);
//        @Test
//        @DisplayName("新規追加")
//        void insertTest() throws Exception {
//            mvc.perform(requestBuilder)
//                    .andExpect(status().isOk());
//        }
//    }
}
