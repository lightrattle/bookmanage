package com.bookmanage.service.impl;

import com.bookmanage.entity.User;
import com.bookmanage.mapper.UserMapper;
import com.bookmanage.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceImpl {
    @Autowired
    UserMapper userMapper;

    @Override
    public User loginUser (String username, String password){
        return userMapper.loginUser(username, password);
    }

    @Override
    public boolean createUser (String nickname, String username, String password){
        return userMapper.createUser(nickname, username, password);
    }
}
