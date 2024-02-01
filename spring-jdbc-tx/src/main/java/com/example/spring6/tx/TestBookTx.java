package com.example.spring6.tx;

import com.example.spring6.tx.controller.BookController;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class TestBookTx {

    @Resource
    BookController bookController;

    @Test
    public void testBuyBook() {
        bookController.buyBook(1, 1);

    }

}
