package com.bookmanage.controller;

import com.bookmanage.entity.User;
import com.bookmanage.service.impl.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String loginUser(@RequestParam("username") String username, @RequestParam("password") String password,
                            Model model, HttpSession session){
        User user = userService.loginUser(username, password);
        if(user != null){//成功
            model.addAttribute("msg","登录完成！ 欢迎你！ "+user.getUsername());
            session.setAttribute("loginUser", username);
            session.setAttribute("userid",user.getUserid());
            return "<script>" +
                    "alert('登录完成！');" +
                    "location.href='/home.html';" +
                    "</script>";
        }else{
            model.addAttribute("msg", "登录出错！用户名或密码错误！");
        }
        return "<script>" +
                "alert('登录出错！');" +
                "location.href='/login.html';" +
                "</script>";
    }
    @PostMapping("/createUser")
    //注册功能，保存数据
    public String createUser(String nickname, String username, String password, String password_2){
        if(password.equals(password_2) && userService.createUser(nickname, username, password)) {
            return "<script>" +
                    "alert('注册完成！');" +
                    "location.href='/login.html';" +
                    "</script>";
        }
        return "<script>" +
                "alert('注册出错！');" +
                "location.href='/createUser.html';" +
                "</script>";
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
}
