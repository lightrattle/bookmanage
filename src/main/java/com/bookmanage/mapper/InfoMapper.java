package com.bookmanage.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface InfoMapper {
    public List<Map<String, Object>> getInfoListForNew();

    public List<Map<String, Object>> getInfoListForUser();

    public boolean insertOneInfo(int bookid, int judge, Date infotime, String infocontent);

    public boolean deleteOneInfo(int infoid);
}
