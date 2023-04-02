package com.bookmanage.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RecomMapper {
    public List<Map<String, Object>> getRecomListByBooktype(String booktype);

    public List<Map<String, Object>> getRecomListByUserid(int userid);

    public List<Map<String, Object>> getRecomListByMajor(String major);

    public List<Map<String, Object>> getRecomListByMajorAndDevelop(String major, String develop);

    public List<Map<String, Object>> getRecomListByBookid(int bookid);

    public boolean insertOneRecom(int userid, String major, String develop, int bookid, String reason);

    public boolean deleteOneRecom(int recomid);
}
