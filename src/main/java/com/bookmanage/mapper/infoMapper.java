package com.bookmanage.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface infoMapper {
    public List<Map<String, Object>> getInfoList();

    public boolean insertOneInfo(int bookid, Date infotime);

    public boolean deleteOneInfo(int infoid);
}
