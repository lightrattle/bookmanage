package com.bookmanage.mapper;

import com.bookmanage.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User loginUser (String username, String password);
    boolean createUser (String nickname,String username,String password);
}
