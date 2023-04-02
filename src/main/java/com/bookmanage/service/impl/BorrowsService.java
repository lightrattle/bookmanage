package com.bookmanage.service.impl;

import com.bookmanage.mapper.BorrowsMapper;
import com.bookmanage.service.BorrowsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowsService implements BorrowsServiceImpl {
    @Autowired
    BorrowsMapper borrowsMapper;


}
