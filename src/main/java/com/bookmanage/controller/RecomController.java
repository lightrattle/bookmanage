package com.bookmanage.controller;

import com.bookmanage.service.impl.RecomService;
import org.apache.ibatis.mapping.MappedStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/recom", method={RequestMethod.GET, RequestMethod.POST})
@EnableAutoConfiguration
public class RecomController {
    @Autowired
    private RecomService recomService;

    @RequestMapping("/getRecomList")
    public List<Map<String, Object>> getRecomList() {
        return recomService.getRecomList();
    }

    @RequestMapping("/getExtroName")
    public List<Map<String, Object>> getExtroName(){
        return recomService.getExtroName();
    }

    @RequestMapping("/getExtroMajor")
    public List<Map<String, Object>> getExtroMajor(){
        return recomService.getExtroMajor();
    }

    @RequestMapping("/getExtroDevelop")
    public List<Map<String, Object>> getExtroDevelop(){
        return recomService.getExtroDevelop();
    }

    @RequestMapping("/getRecomListByUsernameAndMajorAndDevelop")
    public List<Map<String, Object>> getRecomListByUsernameAndMajorAndDevelop(
            String username, String major, String develop){
        return recomService.getRecomListByUsernameAndMajorAndDevelop(username, major, develop);
    }

    @RequestMapping("/getRecomListByBooktype")
    public List<Map<String, Object>> getRecomListByBooktype(String booktype){
        return recomService.getRecomListByBooktype(booktype);
    }

    @RequestMapping("/getRecomListByUserid")
    public List<Map<String, Object>> getRecomListByUserid(int userid){
        return recomService.getRecomListByUserid(userid);
    }

    @RequestMapping("/getRecomListByUsername")
    public List<Map<String, Object>> getRecomListByUsername(String username){
        return recomService.getRecomListByUsername(username);
    }

    @RequestMapping("/getRecomListByMajor")
    public List<Map<String, Object>> getRecomListByMajor(String major){
        return recomService.getRecomListByMajor(major);
    }

    @RequestMapping("/getRecomListByMajorAndDevelop")
    public List<Map<String, Object>> getRecomListByMajorAndDevelop(String major, String develop){
        return recomService.getRecomListByMajorAndDevelop(major, develop);
    }

    @RequestMapping("/getRecomListByBookid")
    public List<Map<String, Object>> getRecomListByBookid(int bookid){
        return recomService.getRecomListByBookid(bookid);
    }

    @RequestMapping("/insertOneRecom")
    public boolean insertOneRecom(int userid, String major, String develop, int bookid, String reason){
        return recomService.insertOneRecom(userid, major, develop, bookid, reason);
    }

    @RequestMapping("/deleteOneRecom")
    public boolean deleteOneRecom(int recomid){
        return recomService.deleteOneRecom(recomid);
    }
}
