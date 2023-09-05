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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest
public class BookControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    BookService bookService;

    @Nested
    class findAll {
        final MockHttpServletRequestBuilder requestBuilder = get("/book/index").accept(MediaType.TEXT_HTML);


        @Test
        @DisplayName("全件検索")
        void findAllTest() throws Exception {
            mvc.perform(requestBuilder)
                    .andExpect(status().isOk())
                    .andExpect(view().name("book/index"));
        }

        @Test
        @DisplayName("名前一致検索")
        void findByNameLikeTest() throws Exception {
            mvc.perform(requestBuilder)
                    .andExpect(status().isOk())
                    .andExpect(view().name("book/index"));
        }
    }

    @Nested
    class insert {

        final MultiValueMap<String, String> valueMap =
                new LinkedMultiValueMap<>() {{
                    add("id", "101");
                    add("name", "弱虫ペダル10");
                    add("price", "1000");
                    add("categoryId", "1");
                }};

        MockHttpServletRequestBuilder createRequest(MultiValueMap<String, String> formData) {
            return post("/book/insertComplete")
                    .params(formData)
                    .accept(MediaType.TEXT_HTML);
        }

        @Test
        @DisplayName("テスト")
        void insertTest() throws Exception {
            mvc.perform(createRequest(valueMap))
                    .andExpect(status().is3xxRedirection())
                    .andExpect(redirectedUrl("index"));
        }
    }
}
