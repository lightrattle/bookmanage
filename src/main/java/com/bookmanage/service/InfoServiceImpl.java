package com.bookmanage.service;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public interface InfoServiceImpl {
    List<Map<String, Object>> getInfoList();

    boolean insertOneInfo(int bookid, Date infotime);

    boolean deleteOneInfo(int infoid);
}
