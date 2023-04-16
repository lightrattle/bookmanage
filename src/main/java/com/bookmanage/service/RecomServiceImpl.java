package com.bookmanage.service;

import com.bookmanage.mapper.RecomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface RecomServiceImpl {
    public List<Map<String, Object>> getExtroName();

    public List<Map<String, Object>> getExtroMajor();

    public List<Map<String, Object>> getExtroDevelop();

    public List<Map<String, Object>> getRecomListByUsernameAndMajorAndDevelop(
            String username, String major, String develop);
    public List<Map<String, Object>> getRecomListByBooktype(String booktype);

    public List<Map<String, Object>> getRecomListByUserid(int userid);

    public List<Map<String, Object>> getRecomListByUsername(String username);


    public List<Map<String, Object>> getRecomListByMajor(String major);

    public List<Map<String, Object>> getRecomListByMajorAndDevelop(String major, String develop);

    public List<Map<String, Object>> getRecomListByBookid(int bookid);

    public boolean insertOneRecom(int userid, String major, String develop, int bookid, String reason);

    public boolean deleteOneRecom(int recomid);
}
