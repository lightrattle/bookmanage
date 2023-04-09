package com.bookmanage.controller;

import com.bookmanage.service.impl.BooksService;
import com.bookmanage.utils.MultipartFileToFile;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/books", method={RequestMethod.GET, RequestMethod.POST})
@EnableAutoConfiguration
public class BooksController {
    @Autowired
    private BooksService booksService;

    @RequestMapping("/getAllBooks")//查找所有书（全部）
    public List<Map<String, Object>> getAllBooks(){
        return booksService.getAllBooks();
    }

    @RequestMapping("/getBooksByTypes")//按类型查找书
    public List<Map<String, Object>> getBooksByTypes(String booktype){
        return booksService.getBooksByTypes(booktype);
    }

    @RequestMapping("/getBooksOfLendnum")//按借阅次数查找书（热门）
    public List<Map<String, Object>> getBooksOfLendnum(){
        return booksService.getBooksOfLendnum();
    }

    @RequestMapping("/getBooksByHistory")//根据历史借阅推荐，个性化推荐的核心部分
    public List<Map<String, Object>> getBooksByHistory(int userid) {
        return booksService.getBooksByHistory(userid);
    }

    @RequestMapping("/getBooksByBook")//根据所选图书推荐与之相关的图书
    public List<Map<String, Object>> getBooksByBook(int bookid){//根据所选图书获取与之有关的图书
        return booksService.getBooksByBook(bookid);
    }

    @RequestMapping("/getBooksByRecomAndUsername")//专家推荐的图书，根据专家名筛选
    public List<Map<String, Object>> getBooksByRecomAndUsername(String username){
        return booksService.getBooksByRecomAndUsername(username);
    }

    @RequestMapping("/getBooksByRecomAndMajor")//专家推荐的图书，根据专业筛选
    public List<Map<String, Object>> getBooksByRecomAndMajor(String major){
        return booksService.getBooksByRecomAndMajor(major);
    }

    @RequestMapping("/getBooksByRecomAndDevelop")//专家推荐的图书，根据专业、发展方向筛选
    public List<Map<String, Object>> getBooksByRecomAndDevelop(String major, String develop){
        return booksService.getBooksByRecomAndDevelop(major, develop);
    }

    @RequestMapping("/insertOneBook")//插入一条书数据
    public boolean insertOneBook(String bookname, String booktype, String image, int allnum, String intro){
        return booksService.insertOneBook(bookname, booktype, image, allnum, intro);
    }
    @RequestMapping("/insertOneBookImage")
    public String insertOneBookImage(HttpServletRequest request, HttpServletRequest response, HttpSession session){
        MultipartHttpServletRequest multipartRequest=(MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("file");
        assert multipartFile != null;
        MultipartFileToFile.saveMultipartFile(multipartFile, "src/main/resources/static/images");
        return MultipartFileToFile.saveMultipartFile(multipartFile, "target/classes/static/images");
    }

    @RequestMapping("/updateLendnum")//借阅一次
    public boolean updateLendnum(int bookid){
        return booksService.updateLendnum(bookid);
    }

    @RequestMapping("/deleteOneBook")//删除一本书
    public boolean deleteOneBook(int bookid) {return booksService.deleteOneBook(bookid);}

}
