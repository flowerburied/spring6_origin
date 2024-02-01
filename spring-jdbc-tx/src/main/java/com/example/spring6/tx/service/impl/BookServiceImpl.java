package com.example.spring6.tx.service.impl;

import com.example.spring6.tx.dao.BookDao;
import com.example.spring6.tx.service.BookService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    BookDao bookDao;

    @Override
    public void buyBook(Integer bookId, Integer userId) {
        //根据图书id查询图书价格
        Integer price = bookDao.getBookPriceByBookId(bookId);

        //更新图书表库存量 -1
        bookDao.updateStock(bookId);

        //更新用户表用户余额 -图书价格
        bookDao.updateUserBalance(userId,price);
    }
}
