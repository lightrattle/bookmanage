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

    @RequestMapping("/getInfoList")
    public List<Map<String, Object>> getInfoList(){
        return infoService.getInfoList();
    }

    @RequestMapping("/insertOneInfo")
    public boolean insertOneInfo(int bookid, Date infotime){
        return infoService.insertOneInfo(bookid, infotime);
    }

    @RequestMapping("/deleteOneInfo")
    public boolean deleteOneInfo(int infoid){
        return infoService.deleteOneInfo(infoid);
    }
}
