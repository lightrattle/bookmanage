package com.bookmanage.service.impl;

import com.bookmanage.mapper.BorrowsMapper;
import com.bookmanage.service.BorrowsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class BorrowsService implements BorrowsServiceImpl {
    @Autowired
    BorrowsMapper borrowsMapper;

    @Override
    public List<Map<String, Object>> getBorrowsListByUserid(int userid) {
        return borrowsMapper.getBorrowsListByUserid(userid);
    }

    @Override
    public List<Map<String, Object>> getBorrowsListByBookid(int bookid) {
        return borrowsMapper.getBorrowsListByBookid(bookid);
    }

    @Override
    public List<Map<String, Object>> getBorrowsListByStatus(int status) {
        return borrowsMapper.getBorrowsListByStatus(status);
    }

    @Override
    public boolean insertOneBorrow(int userid, Date lendtime, int bookid) {
        return borrowsMapper.insertOneBorrow(userid, lendtime, bookid);
    }

    @Override
    public boolean updateOneStatus(int userid, int bookid) {
        return borrowsMapper.updateOneStatus(userid, bookid);
    }
}
