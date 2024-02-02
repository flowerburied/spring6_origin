package com.example.spring6.tx.service.impl;

import com.example.spring6.tx.service.BookService;
import com.example.spring6.tx.service.CheckoutService;
import jakarta.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;

public class CheckoutServiceImpl implements CheckoutService {

    @Resource
    BookService bookService;


    @Transactional
    @Override
    public void checkout(Integer[] bookIds, Integer userId) {
        for (Integer bookId : bookIds) {
            bookService.buyBook(bookId, userId);
        }
    }
}
