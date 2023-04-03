package com.bookmanage.controller;

import com.bookmanage.service.impl.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/books", method={RequestMethod.GET, RequestMethod.POST})
@EnableAutoConfiguration
public class BooksController {
    @Autowired
    private BooksService booksService;


}