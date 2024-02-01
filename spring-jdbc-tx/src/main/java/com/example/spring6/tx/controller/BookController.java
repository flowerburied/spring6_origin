package com.example.spring6.tx.controller;

import com.example.spring6.tx.service.BookService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    @Resource
    BookService bookService;

    public void buyBook(Integer bookId,Integer userId){

        bookService.buyBook(bookId,userId);
    }
}
