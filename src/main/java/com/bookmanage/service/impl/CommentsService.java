package com.bookmanage.service.impl;

import com.bookmanage.mapper.CommentsMapper;
import com.bookmanage.service.CommentsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CommentsService implements CommentsServiceImpl {
    @Autowired
    CommentsMapper commentsMapper;

    @Override
    public List<Map<String, Object>> getCommentsListByUserid(int userid) {
        return commentsMapper.getCommentsListByUserid(userid);
    }

    @Override
    public List<Map<String, Object>> getCommentsListByBookid(int bookid) {
        return commentsMapper.getCommentsListByBookid(bookid);
    }

    @Override
    public boolean insertOneComment(int userid, Date commenttime, int bookid, String content) {
        return commentsMapper.insertOneComment(userid, commenttime, bookid, content);
    }

    @Override
    public boolean deleteOneComment(int userid, int bookid, String content) {
        return commentsMapper.deleteOneComment(userid, bookid, content);
    }
}
