package com.bookmanage.service.impl;

import com.bookmanage.mapper.RecomMapper;
import com.bookmanage.mapper.UserMapper;
import com.bookmanage.service.RecomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RecomService implements RecomServiceImpl {
    @Autowired
    RecomMapper recomMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public List<Map<String, Object>> getRecomListByBooktype(String booktype) {
        return recomMapper.getRecomListByBooktype(booktype);
    }

    @Override
    public List<Map<String, Object>> getRecomListByUserid(int userid) {
        return recomMapper.getRecomListByUserid(userid);
    }

    @Override
    public List<Map<String, Object>> getRecomListByUsername(String username) {
        int userid = userMapper.getUseridByUsername(username);
        return recomMapper.getRecomListByUserid(userid);
    }

    @Override
    public List<Map<String, Object>> getRecomListByMajor(String major) {
        return recomMapper.getRecomListByMajor(major);
    }

    @Override
    public List<Map<String, Object>> getRecomListByMajorAndDevelop(String major, String develop) {
        return recomMapper.getRecomListByMajorAndDevelop(major, develop);
    }

    @Override
    public List<Map<String, Object>> getRecomListByBookid(int bookid) {
        return recomMapper.getRecomListByBookid(bookid);
    }

    @Override
    public boolean insertOneRecom(int userid, String major, String develop, int bookid, String reason) {
        return recomMapper.insertOneRecom(userid, major, develop, bookid, reason);
    }

    @Override
    public boolean deleteOneRecom(int recomid) {
        return recomMapper.deleteOneRecom(recomid);
    }
}
