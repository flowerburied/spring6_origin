package com.example.spring6.tx.controller;

import com.example.spring6.tx.service.BookService;
import com.example.spring6.tx.service.CheckoutService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    @Resource
    BookService bookService;
    @Resource
    CheckoutService checkoutService;

    public void buyBook(Integer bookId, Integer userId) {

        bookService.buyBook(bookId, userId);
    }

    public void checkout(Integer[] bookIds, Integer userId) {

        checkoutService.checkout(bookIds, userId);
    }
}
