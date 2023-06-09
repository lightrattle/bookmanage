package com.bookmanage.controller;

import com.bookmanage.service.impl.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/comments", method={RequestMethod.GET, RequestMethod.POST})
@EnableAutoConfiguration
public class CommentsController {
    @Autowired
    private CommentsService commentsService;

    @RequestMapping("/getCommentsListByUserid")//查看某用户对书的评论
    public List<Map<String, Object>> getCommentsListByUserid(int userid){
        return commentsService.getCommentsListByUserid(userid);
    }

    @RequestMapping("/getCommentsListByBookid")//根据书获取ID
    public List<Map<String, Object>> getCommentsListByBookid(int bookid){
        return commentsService.getCommentsListByBookid(bookid);
    }

    @RequestMapping("/insertOneComment")//评论
    public boolean insertOneComment(int userid, Date commenttime, int bookid, String content){
        return commentsService.insertOneComment(userid, commenttime, bookid, content);
    }

    @RequestMapping("/deleteOneComment")//删除评论
    public boolean deleteOneComment(int userid, int bookid, String content){
        return commentsService.deleteOneComment(userid, bookid, content);
    }
}
