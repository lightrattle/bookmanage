package com.bookmanage.service.impl;

import com.bookmanage.mapper.InfoMapper;
import com.bookmanage.service.InfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class InfoService implements InfoServiceImpl {
    @Autowired
    InfoMapper infoMapper;

    @Override
    public List<Map<String, Object>> getInfoList() {
        return infoMapper.getInfoList();
    }

    @Override
    public boolean insertOneInfo(int bookid, Date infotime) {
        return infoMapper.insertOneInfo(bookid, infotime);
    }

    @Override
    public boolean deleteOneInfo(int infoid) {
        return infoMapper.deleteOneInfo(infoid);
    }
}
