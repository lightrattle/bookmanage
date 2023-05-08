package com.bookmanage.service.impl;

import com.bookmanage.mapper.*;
import com.bookmanage.service.BooksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public int getLatestBookid() {
        return booksMapper.getlatestBookid();
    }

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
        //根据历史借阅推荐，个性化推荐的核心部分
        // 根据userid获取该用户历史查阅书籍
        List<Map<String, Object>> historyList = borrowsMapper.getBorrowsListByUserid(userid);
        // 遍历获得该用户所借阅书籍的分类及每种分类所借数量
        Map<String, Double> lengNumberList = null;
        for (Map<String, Object> stringObjectMap : historyList) {
            String classify = (String) stringObjectMap.get("booktype");
            if (lengNumberList.get(classify) == null) {
                lengNumberList.put(classify, 0.0);
            } else {
                double oldNum = lengNumberList.get(classify);
                double newNum = oldNum + 1.0;
                lengNumberList.replace(classify, newNum);
            }
        }
        // 将各种数量求和得到每类的百分比
        int allLendNum = historyList.size();
        double count = 0.0;
        int num = 0;
        double[] lunpan = new double[lengNumberList!=null?lengNumberList.size():0];
        if(lunpan.length != 0){
            for(Map.Entry<String, Double> entry: lengNumberList.entrySet()){
                double item = entry.getValue()/(allLendNum * 1.0) + count;
                count+= item;
                entry.setValue(item);
                lunpan[num] = count;
            }
            //生成五次随机数，并根据百分比得到这五个随机数处于哪一类
            int[] chooses = new int[5];
            for(int i = 0; i < 5; i++){
                int cho = 0;
                double item = Math.random();
                for(int j = 0; j < lunpan.length; j++){
                    if(item <= lunpan[i]){
                        break;
                    }
                    cho++;
                }
                chooses[i] = cho;
            }
            String[] choosesType = new String[5];
            for(int i = 0; i < 5; i++){
                int tmp = 0;
                for(String str: lengNumberList.keySet()){
                    if(tmp == chooses[i]){
                        choosesType[i] = str;
                        break;
                    }
                    tmp++;
                }
            }
            // 在对应的类别中选取一本书
            List<Map<String, Object>> books = null;
            for(int i = 0; i< 5; i++){
                // 获得对于类别的所有书籍
                List<Map<String, Object>> booksList = booksMapper.getBooksByTypes(choosesType[i]);
                // 生成在最大数量范围内的随机数
                int chooseOne = (int)(Math.random() * booksList.size() + 0);
                // 选取该随机数对应的书，并加入List
                Map<String, Object> oneBook = booksList.get(chooseOne);
                books.add(oneBook);
            }
            // 将上面生成的5本推荐书作为返回值
            return books;
        }
        else return null;
    }

    @Override
    public List<Map<String, Object>> getBooksByBook(int bookid) {
        // 根据所选图书推荐与之相关的图书
        // 根据本书id获得本书类别
        String classify = (String)booksMapper.getOneBookByBookid(bookid).get("booktype");
        // 根据该类别获取所有书籍
        List<Map<String, Object>> theClassifyBooks = booksMapper.getBooksByTypes(classify);
        // 生成五个随机数，并将对应的书加入books
        List<Map<String, Object>> books = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            int choose = (int)(Math.random() * theClassifyBooks.size() + 0);
            books.add(theClassifyBooks.get(choose));
        }
        // 返回books
        return books;
    }

    @Override
    public List<Map<String, Object>> getBooksByBookname(String bookname) {
        return booksMapper.getBooksByBookname(bookname);
    }

    @Override
    public List<Map<String, Object>> getBooksOfLendnum() {
        return booksMapper.getBooksOfLendnum();
    }

    @Override
    public List<Map<String, Object>> getBookByRecom(){
        return recomMapper.getBookByRecom();
    }

    @Override
    public List<Map<String, Object>> getBooksByRecomAndBooktype(String booktype) {
        return recomMapper.getBooksByRecomAndBooktype(booktype);
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

    @Override
    public String lendOne(int userid, int bookid) {
        int remainNum = booksMapper.getRemainNumByBookid(bookid);
        int maxLend = userMapper.getMaxlendByUserid(userid);
        int lended = userMapper.getLendedByUserid(userid);
        int canLend = maxLend - lended;
        if(canLend > 0 && remainNum > 0){
            Date nowTime = new Date();
            booksMapper.updateLendnum(bookid);
            userMapper.updateLended(userid);
            borrowsMapper.insertOneBorrow(userid, nowTime, bookid);
            return "借阅成功！";
        }
        else{
            return "借阅失败！";
        }
    }

    @Override
    public List<Map<String, Object>> getBooksBySearchString(String searchString) {
        if(searchString.length() == 0){
            return booksMapper.getAllBooks();
        }
        else {
            StringBuilder str = new StringBuilder();
            for(int i = 0; i < searchString.length(); i++){
                str.append(searchString.charAt(i)).append("%");
            }
            return booksMapper.getBooksBySearchString(new String(str));
        }
    }

    @Override
    public boolean updateAllnum(int bookid, int allnum) {
        return booksMapper.updateAllnum(bookid, allnum);
    }

    @Override
    public boolean updateIntro(int bookid, String intro) {
        return booksMapper.updateIntro(bookid, intro);
    }
}
