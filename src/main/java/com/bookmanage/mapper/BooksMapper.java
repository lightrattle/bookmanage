package com.bookmanage.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BooksMapper {
    public Map<String, Object> getOneBookByBookid(int bookid);

    public List<Map<String, Object>> getAllBooks();

    public List<Map<String, Object>> getBooksByTypes(String booktype);

    public List<Map<String, Object>> getBooksOfLendnum();

    public List<Map<String, Object>> getBooksByBookname(String bookname);

    public boolean insertOneBook(String bookname, String booktype, String image, int allnum, String intro);

    public Integer getlatestBookid();

    public boolean updateLendnum(int bookid);

    public boolean deleteOneBook(int bookid);

    public int getRemainNumByBookid(int bookid);


}
