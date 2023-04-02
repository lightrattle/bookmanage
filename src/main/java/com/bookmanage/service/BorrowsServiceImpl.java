package com.bookmanage.service;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public interface BorrowsServiceImpl {
    List<Map<String, Object>> getBorrowsListByUserid(int userid);

    List<Map<String, Object>> getBorrowsListByBookid(int bookid);

    List<Map<String, Object>> getBorrowsListByStatus(int status);

    boolean insertOneBorrow(int userid, Date lendtime, int bookid);

    boolean updateOneStatus(int userid, int bookid);
}
