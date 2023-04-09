package com.bookmanage.service;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public interface InfoServiceImpl {
    List<Map<String, Object>> getInfoListForNew();

    List<Map<String, Object>> getInfoListForUser(int userid);

    boolean insertOneInfo(int bookid, int judeg, Date infotime, String infocontent);

    boolean deleteOneInfo(int infoid);
}
