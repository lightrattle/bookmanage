package com.bookmanage.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface BooksServiceImpl {
    List<Map<String, Object>> getAllBooks();

    List<Map<String, Object>> getBooksByTypes(String booktype);

    List<Map<String, Object>> getBooksOfLendnum();

    boolean insertOneBook(String bookname, String booktype, String image, int allnum, String intro);

    boolean updateLendnum(int bookid);
}
