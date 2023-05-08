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

    List<Map<String, Object>> listAllUser();

    boolean resetNickname(int userid, String nickname);

    boolean resetStatus(int userid, int status);

    boolean resetMaxlend(int userid, int maxlend);

    boolean resetPassword(int userid);

    boolean deleteUser(int userid);

    int getMaxlendByUserid(int userid);

    int getLendedByUserid(int userid);

    String getPasswordByUserid(int userid);

    boolean updatePassword(int userid, String password);

    boolean updateLended(int userid);
}
