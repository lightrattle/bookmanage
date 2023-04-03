package com.bookmanage.controller;

import com.bookmanage.service.impl.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/books", method={RequestMethod.GET, RequestMethod.POST})
@EnableAutoConfiguration
public class BooksController {
    @Autowired
    private BooksService booksService;

    @RequestMapping("/getAllBooks")
    public List<Map<String, Object>> getAllBooks(){
        return booksService.getAllBooks();
    }

    @RequestMapping("/getBooksByTypes")
    public List<Map<String, Object>> getBooksByTypes(String booktype){
        return booksService.getBooksByTypes(booktype);
    }

    @RequestMapping("/getBooksOfLendnum")
    public List<Map<String, Object>> getBooksOfLendnum(){
        return booksService.getBooksOfLendnum();
    }

    @RequestMapping("/insertOneBook")
    public boolean insertOneBook(String bookname, String booktype, String image, int allnum, String intro){
        return booksService.insertOneBook(bookname, booktype, image, allnum, intro);
    }

    @RequestMapping("/updateLendnum")
    public boolean updateLendnum(int bookid){
        return booksService.updateLendnum(bookid);
    }
}
