package com.bookmanage.service;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public interface CommentsServiceImpl {
    List<Map<String, Object>> getCommentsListByUserid(int userid);

    List<Map<String, Object>> getCommentsListByBookid(int bookid);

    boolean insertOneComment(int userid, Date commenttime, int bookid, String content);

    boolean deleteOneComment(int userid, int bookid, String content);
}
