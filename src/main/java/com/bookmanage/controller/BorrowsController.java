package com.bookmanage.controller;

import com.bookmanage.service.impl.BorrowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/borrows", method={RequestMethod.GET, RequestMethod.POST})
@EnableAutoConfiguration
public class BorrowsController {
    @Autowired
    private BorrowsService borrowsService;

    @RequestMapping("/getBorrowsListByUserid")
    public List<Map<String, Object>> getBorrowsListByUserid(int userid){
        return borrowsService.getBorrowsListByUserid(userid);
    }

    @RequestMapping("/getBorrowsListByBookid")
    public List<Map<String, Object>> getBorrowsListByBookid(int bookid){
        return borrowsService.getBorrowsListByBookid(bookid);
    }

    @RequestMapping("/getBorrowsListByStatus")
    public List<Map<String, Object>> getBorrowsListByStatus(int status){
        return borrowsService.getBorrowsListByStatus(status);
    }

    @RequestMapping("/insertOneBorrow")
    public boolean insertOneBorrow(int userid, Date lendtime, int bookid){
        return borrowsService.insertOneBorrow(userid, lendtime, bookid);
    }

    @RequestMapping("/updateOneStatus")
    public boolean updateOneStatus(int userid, int bookid){
        return borrowsService.updateOneStatus(userid, bookid);
    }
}
