package com.bookmanage.service;

import com.bookmanage.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserServiceImpl {
    User loginUser (String username, String password);

    boolean createUser (String nickname, String username, String password);

    boolean removeUser(int userid);

    List<Map<String, Object>> getUsernameForRecom();

    List<Map<String, Object>> listAllUser();

    boolean resetNickname(int userid, String nickname);

    boolean resetStatus(int userid, int status);

    boolean resetMaxlend(int userid, int maxlend);

    boolean resetPassword(int userid);

    String updatePassword(int userid, String oldPassword, String newPassword);

    boolean deleteUser(int userid);
}
