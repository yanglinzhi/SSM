package com.ylz.spring.controller;

import com.ylz.spring.service.BookService;
import com.ylz.spring.service.CheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CheckOutService checkOutService;

    public void buyBook(Integer userId,Integer bookId){
        bookService.buyBook(userId,bookId);
    }

    public void checkOut(Integer userId,Integer[] bookIds){
        checkOutService.checkOut(userId,bookIds);
    }
}
