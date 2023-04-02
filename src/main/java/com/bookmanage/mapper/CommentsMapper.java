package com.bookmanage.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface CommentsMapper {
    public List<Map<String, Object>> getCommentsListByUserid(int userid);

    public List<Map<String, Object>> getCommentsListByBookid(int bookid);

    public boolean insertOneComment(int userid, Date commenttime, int bookid, String content);

    public boolean deleteOneComment(int userid, int bookid, String content);
}
