package com.bookmanage.service.impl;

import com.bookmanage.mapper.*;
import com.bookmanage.service.BooksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class BooksService implements BooksServiceImpl {
    @Autowired
    BooksMapper booksMapper;
    @Autowired
    InfoMapper infoMapper;
    @Autowired
    BorrowsMapper borrowsMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    RecomMapper recomMapper;

    @Override
    public List<Map<String, Object>> getAllBooks() {
        return booksMapper.getAllBooks();
    }

    @Override
    public List<Map<String, Object>> getBooksByTypes(String booktype) {
        return booksMapper.getBooksByTypes(booktype);
    }

    @Override
    public List<Map<String, Object>> getBooksByHistory(int userid) {
        //TODO 根据历史借阅推荐，个性化推荐的核心部分



        return null;
    }

    @Override
    public List<Map<String, Object>> getBooksByBook(int bookid) {
        //TODO 根据所选图书推荐与之相关的图书



        return null;
    }

    @Override
    public List<Map<String, Object>> getBooksOfLendnum() {
        return booksMapper.getBooksOfLendnum();
    }

    @Override
    public List<Map<String, Object>> getBooksByRecomAndUsername(String username) {
        int userid = userMapper.getUseridByUsername(username);
        return recomMapper.getBooksByRecomAndUserid(userid);
    }

    @Override
    public List<Map<String, Object>> getBooksByRecomAndMajor(String major) {
        return recomMapper.getBooksByRecomAndMajor(major);
    }

    @Override
    public List<Map<String, Object>> getBooksByRecomAndDevelop(String major, String develop) {
        return recomMapper.getBooksByRecomAndDevelop(major, develop);
    }

    @Override
    public boolean insertOneBook(String bookname, String booktype, String image, int allnum, String intro) {
        //加入了新书，故推送通知
        Date infotime = new Date();
        boolean res = booksMapper.insertOneBook(bookname, booktype, image, allnum, intro);
        int bookid = booksMapper.getlatestBookid();
        String infocontentfornew = bookname + "（新书）于" + infotime + "已经上架了！快来阅读吧！";
        infoMapper.insertOneInfo(bookid, 0, infotime, infocontentfornew);//新书冷启动

        //推送给可能感兴趣的人
        List<Map<String, Object>> users = borrowsMapper.getUsersByBooktype(booktype);
        for (Map<String, Object> user : users) {
            String infocontentforuser = (String) user.get("username") + "（用户）,您可能感兴趣的书：" + bookname
                    + "已经上架了，快来阅读吧！";
            infoMapper.insertOneInfo(bookid, 1, infotime, infocontentforuser);//新书推送给可能感兴趣的人
        }

        return res;
    }

    @Override
    public boolean updateLendnum(int bookid) {
        return booksMapper.updateLendnum(bookid);
    }

    @Override
    public boolean deleteOneBook(int bookid) {
        return booksMapper.deleteOneBook(bookid);
    }
}
