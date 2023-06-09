package com.bookmanage.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RecomMapper {
    public List<Map<String, Object>> getRecomList();
    public List<Map<String, Object>> getExtroName();

    public List<Map<String, Object>> getExtroMajor();

    public List<Map<String, Object>> getExtroDevelop();

    public List<Map<String, Object>> getRecomListByUsernameAndMajorAndDevelop(
            String username, String major, String develop);

    public List<Map<String, Object>> getBookByRecom();

    public List<Map<String, Object>> getBooksByRecomAndBooktype(String booktype);
    public List<Map<String, Object>> getRecomListByBooktype(String booktype);

    public List<Map<String, Object>> getRecomListByUserid(int userid);

    public List<Map<String, Object>> getRecomListByMajor(String major);

    public List<Map<String, Object>> getRecomListByMajorAndDevelop(String major, String develop);

    public List<Map<String, Object>> getRecomListByBookid(int bookid);

    public List<Map<String, Object>> getBooksByRecomAndUserid(int userid);

    public List<Map<String, Object>> getBooksByRecomAndMajor(String major);

    public List<Map<String, Object>> getBooksByRecomAndDevelop(String major, String develop);

    public boolean insertOneRecom(int userid, String major, String develop, int bookid, String reason);

    public boolean deleteOneRecom(int recomid);
}
