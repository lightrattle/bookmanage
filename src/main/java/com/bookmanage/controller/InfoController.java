package com.bookmanage.controller;

import com.bookmanage.service.impl.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/info", method={RequestMethod.GET, RequestMethod.POST})
@EnableAutoConfiguration
public class InfoController {
    @Autowired
    private InfoService infoService;

    @RequestMapping("/getInfoListForNew")
    public List<Map<String, Object>> getInfoListForNew(){
        return infoService.getInfoListForNew();
    }

    @RequestMapping("/getInfoListForUser")
    public List<Map<String, Object>> getInfoListForUser(int userid){
        return infoService.getInfoListForUser(userid);
    }

    @RequestMapping("/insertOneInfo")
    public boolean insertOneInfo(int bookid, int judge, Date infotime, String infocontent){
        return infoService.insertOneInfo(bookid, judge, infotime, infocontent);
    }

    @RequestMapping("/deleteOneInfo")
    public boolean deleteOneInfo(int infoid){
        return infoService.deleteOneInfo(infoid);
    }
}
