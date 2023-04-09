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
}
