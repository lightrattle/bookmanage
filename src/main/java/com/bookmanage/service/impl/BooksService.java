package com.bookmanage.service.impl;

import com.bookmanage.mapper.BooksMapper;
import com.bookmanage.service.BooksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksService implements BooksServiceImpl {
    @Autowired
    BooksMapper booksMapper;


}
