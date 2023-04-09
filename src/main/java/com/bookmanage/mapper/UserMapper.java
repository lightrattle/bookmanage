package com.bookmanage.mapper;

import com.bookmanage.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    User loginUser (String username, String password);

    String getUsernameByUserid(int userid);

    Integer getUseridByUsername(String username);
    boolean createUser (String nickname,String username,String password);
    boolean removeUser(int userid);

    List<Map<String, Object>> getUsernameForRecom();
}
