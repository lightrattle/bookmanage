package com.bookmanage.service.impl;

import com.bookmanage.entity.User;
import com.bookmanage.mapper.UserMapper;
import com.bookmanage.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    @Override
    public boolean removeUser(int userid) {
        return userMapper.removeUser(userid);
    }

    @Override
    public List<Map<String, Object>> getUsernameForRecom() {
        return userMapper.getUsernameForRecom();
    }

    @Override
    public List<Map<String, Object>> listAllUser() {
        return userMapper.listAllUser();
    }

    @Override
    public boolean resetNickname(int userid, String nickname) {
        return userMapper.resetNickname(userid, nickname);
    }

    @Override
    public boolean resetStatus(int userid, int status) {
        return userMapper.resetStatus(userid, status);
    }

    @Override
    public boolean resetMaxlend(int userid, int maxlend) {
        return userMapper.resetMaxlend(userid, maxlend);
    }

    @Override
    public boolean resetPassword(int userid) {
        return userMapper.resetPassword(userid);
    }

    @Override
    public String updatePassword(int userid, String oldPassword, String newPassword) {
        if((String)(userMapper.getPasswordByUserid(userid) == oldPassword)){
            userMapper.updatePassword(userid, newPassword);
            return "修改密码成功,下次请使用新密码登录！";
        }
        else {
            return "旧密码不匹配！";
        }
    }

    @Override
    public boolean deleteUser(int userid) {
        return userMapper.deleteUser(userid);
    }
}
