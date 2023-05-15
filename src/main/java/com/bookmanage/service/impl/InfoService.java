package com.bookmanage.service.impl;

import com.bookmanage.mapper.InfoMapper;
import com.bookmanage.mapper.UserMapper;
import com.bookmanage.service.InfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.MacSpi;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class InfoService implements InfoServiceImpl {
    @Autowired
    InfoMapper infoMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public List<Map<String, Object>> getInfoListForNew() {
        return infoMapper.getInfoListForNew();
    }

    @Override
    public List<Map<String, Object>> getInfoListForUser(int userid) {
        String username = userMapper.getUsernameByUserid(userid);
        List<Map<String, Object>> result = new ArrayList<>();
        List<Map<String, Object>> infoes = infoMapper.getInfoListForUser();
        for (Map<String, Object> infoe : infoes) {
            String temp = ((String) infoe.get("infocontent")).split("（")[0];
            if (temp.equals(username)) {
                // 循环遍历一遍，已加入则不重复添加
                boolean flag = false;
                for(int i = 0; i < result.size(); i++){
                    if(infoe.equals(result.get(i))){
                        flag = true;
                        break;
                    }
                }
                if(!flag) {
                    result.add(infoe);
                }
            }
        }
        return result;
    }

    @Override
    public boolean insertOneInfo(int bookid, int judge, Date infotime, String infocontent) {
        return infoMapper.insertOneInfo(bookid, judge, infotime, infocontent);
    }

    @Override
    public boolean deleteOneInfo(int infoid) {
        return infoMapper.deleteOneInfo(infoid);
    }
}
