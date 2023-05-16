package com.bookmanage.controller;

import com.bookmanage.entity.User;
import com.bookmanage.service.impl.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/user", method={RequestMethod.GET, RequestMethod.POST})
@EnableAutoConfiguration
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/loginUser")
    //登录功能
    public Map<String, Object> loginUser(@RequestParam("username") String username, @RequestParam("password") String password,
                            Model model, HttpSession session){
        Map<String, Object> map = new HashMap<>();
        System.out.println(username);
        System.out.println(password);
        User user = userService.loginUser(username, password);
        if(user != null){//成功
            model.addAttribute("msg","登录完成！ 欢迎你！ "+user.getUsername());
            model.addAttribute("loginUser", username);
            model.addAttribute("userid", user.getUserid());
            model.addAttribute("status", user.getStatus());
            model.addAttribute("nickname", user.getNickname());
            model.addAttribute("maxlend", user.getMaxlend());
            model.addAttribute("lended", user.getLended());
            map.put("msg","登录成功！ 欢迎你！"+user.getUsername());
            map.put("loginUser", username);
            map.put("userid", user.getUserid());
            map.put("status", user.getStatus());
            map.put("nickname", user.getNickname());
            map.put("maxlend", user.getMaxlend());
            map.put("lended", user.getLended());
            session.setAttribute("loginUser", username);
            session.setAttribute("userid",user.getUserid());
            session.setAttribute("status",user.getStatus());
            session.setAttribute("nickname", user.getNickname());
            session.setAttribute("maxlend", user.getMaxlend());
            session.setAttribute("lended", user.getLended());
            return map;
        }else {
            model.addAttribute("msg", "登录失败！用户名或密码错误！");
            model.addAttribute("loginUser", null);
            model.addAttribute("userid",null);
            model.addAttribute("status",null);
            map.put("msg", "登录失败！用户名或密码错误！");
            map.put("loginUser", null);
            map.put("userid", null);
            map.put("status", null);
            map.put("nickname", null);
            map.put("maxlend", null);
            map.put("lended", null);
            return map;
        }
    }
    @RequestMapping("/createUser")
    //注册功能，保存数据
    public boolean createUser(String nickname, String username, String password){
        if(userService.createUser(nickname, username, password)) {
            return true;
        }
        else {
            return false;
        }
    }

    @RequestMapping("/logout")//退出登录
    public String logout(HttpSession session) {
        session.invalidate();
        return "<script>" +
                "location.href='/login.html';" +
                "</script>";
    }

    @PostMapping("/removeUser")
    public boolean removeUser(int userid) {
        return userService.removeUser(userid);
    }

    @RequestMapping("/getUsernameForRecom")
    public List<Map<String, Object>> getUsernameForRecom(){
        return userService.getUsernameForRecom();
    }

    @RequestMapping("/listAllUser")
    public List<Map<String, Object>> listAllUser(){
        return userService.listAllUser();
    }

    @RequestMapping("/resetNickname")
    public boolean resetNickname(int userid, String nickname) {
        return userService.resetNickname(userid, nickname);
    }

    @RequestMapping("/resetStatus")
    public boolean resetStatus(int userid, int status) {
        return userService.resetStatus(userid, status);
    }

    @RequestMapping("/resetMaxlend")
    public boolean resetMaxlend(int userid, int maxlend){
        return userService.resetMaxlend(userid, maxlend);
    }

    @RequestMapping("/resetPassword")
    public boolean resetPassword(int userid){
        return userService.resetPassword(userid);
    }

    @RequestMapping("/updatePassword")
    public String updatePassword(int userid, String oldPassword, String newPassword){
        return userService.updatePassword(userid, oldPassword, newPassword);
    }

    @RequestMapping("/deleteUser")
    public boolean deleteUser(int userid){
        return userService.deleteUser(userid);
    }
}
