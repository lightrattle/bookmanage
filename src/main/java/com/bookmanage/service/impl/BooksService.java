package com.bookmanage.service.impl;

import com.bookmanage.mapper.BooksMapper;
import com.bookmanage.service.BooksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BooksService implements BooksServiceImpl {
    @Autowired
    BooksMapper booksMapper;

    @Override
    public List<Map<String, Object>> getAllBooks() {
        return booksMapper.getAllBooks();
    }

    @Override
    public List<Map<String, Object>> getBooksByTypes(String booktype) {
        return booksMapper.getBooksByTypes(booktype);
    }

    @Override
    public List<Map<String, Object>> getBooksOfLendnum() {
        return booksMapper.getBooksOfLendnum();
    }

    @Override
    public boolean insertOneBook(String bookname, String booktype, String image, int allnum, String intro) {
        return booksMapper.insertOneBook(bookname, booktype, image, allnum, intro);
    }

    @Override
    public boolean updateLendnum(int bookid) {
        return booksMapper.updateLendnum(bookid);
    }
}
