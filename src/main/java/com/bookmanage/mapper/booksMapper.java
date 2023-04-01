package com.bookmanage.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface booksMapper {
    public List<Map<String, Object>> getAllBooks();

    public List<Map<String, Object>> getBooksByTypes(String booktype);

    public List<Map<String, Object>> getBooksOfLendnum();

    public boolean insertOneBook(String bookname, String booktype, String image, int allnum, String intro);

    public boolean updateLendnum(int bookid);
}
