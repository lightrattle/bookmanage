package com.bookmanage.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Service
public interface BooksServiceImpl {
    int getLatestBookid();
    List<Map<String, Object>> getAllBooks();

    List<Map<String, Object>> getBooksByTypes(String booktype);

    List<Map<String, Object>> getBooksByHistory(int userid);

    List<Map<String, Object>> getBooksByBook(int bookid);

    List<Map<String, Object>> getBooksByBookname(String bookname);

    List<Map<String, Object>> getBooksOfLendnum();

    List<Map<String, Object>> getBookByRecom();

    List<Map<String, Object>> getBooksByRecomAndBooktype(String booktype);

    List<Map<String, Object>> getBooksByRecomAndUsername(String username);

    List<Map<String, Object>> getBooksByRecomAndMajor(String major);

    List<Map<String, Object>> getBooksByRecomAndDevelop(String major, String develop);
    boolean insertOneBook(String bookname, String booktype, String image, int allnum, String intro);

    boolean updateLendnum(int bookid);

    boolean deleteOneBook(int bookid);

    boolean lendOne(int userid, int bookid);

    List<Map<String, Object>> getBooksBySearchString(String searchString);

    boolean updateAllnum(int bookid, int allnum);

    boolean updateIntro(int bookid, String intro);
}
