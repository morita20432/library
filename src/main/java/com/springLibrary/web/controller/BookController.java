package com.springLibrary.web.controller;

import com.springLibrary.persistence.entitiy.Book;
import com.springLibrary.service.BookService;
import com.springLibrary.web.form.BookForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/index")
    public String index(Model model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList", bookList);
        return "book/index";
    }

    @GetMapping("/findByNameLike")
    public String findByNameLike(@RequestParam String keyword, Model model) {
        List<Book> bookList = bookService.findByNameLike(keyword);
        model.addAttribute("bookList", bookList);
        return "book/index";
    }

    @GetMapping("/insertMain")
    public String insertMain() {
        return "book/insertMain";
    }

    //todo BookFormはServiceのようにフィールドに配置してはいけない？

    @PostMapping("/insertComplete")
    public String insertComplete(BookForm bookForm) {
        Book book = bookForm.convertToEntity();
        bookService.insert(book);
        return "redirect:index";
    }
}
