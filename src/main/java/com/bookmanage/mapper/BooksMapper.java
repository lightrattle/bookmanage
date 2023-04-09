package com.bookmanage.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BooksMapper {
    public List<Map<String, Object>> getAllBooks();

    public List<Map<String, Object>> getBooksByTypes(String booktype);

    public List<Map<String, Object>> getBooksOfLendnum();

    public boolean insertOneBook(String bookname, String booktype, String image, int allnum, String intro);

    public Integer getlatestBookid();

    public boolean updateLendnum(int bookid);

    public boolean deleteOneBook(int bookid);
}
