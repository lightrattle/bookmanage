package com.bookmanage.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface BorrowsMapper {
    public List<Map<String, Object>> getBorrowsListByUserid(int userid);

    public List<Map<String, Object>> getBorrowsListByBookid(int bookid);

    public List<Map<String, Object>> getBorrowsListByStatus(int status);

    public List<Map<String, Object>> getUsersByBooktype(String booktype);

    public boolean insertOneBorrow(int userid, Date lendtime, int bookid);

    public boolean updateOneStatus(int userid, int borrowid);
}
