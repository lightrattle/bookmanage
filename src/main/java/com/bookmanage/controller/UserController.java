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
        User user = userService.loginUser(username, password);
        if(user != null){//成功
            model.addAttribute("msg","登录完成！ 欢迎你！ "+user.getUsername());
            model.addAttribute("loginUser", username);
            model.addAttribute("userid", user.getUserid());
            map.put("msg","登录成功！ 欢迎你！"+user.getUsername());
            map.put("loginUser", username);
            map.put("userid", user.getUserid());
            session.setAttribute("loginUser", username);
            session.setAttribute("userid",user.getUserid());
            return map;
        }else {
            model.addAttribute("msg", "登录失败！用户名或密码错误！");
            model.addAttribute("loginUser", null);
            model.addAttribute("userid",null);
            map.put("msg", "登录失败！用户名或密码错误！");
            map.put("loginUser", null);
            map.put("userid", null);
            return map;
        }
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
