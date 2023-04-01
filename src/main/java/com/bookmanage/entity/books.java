package com.bookmanage.entity;

public class books {
    private int bookid;
    private String bookname;
    private String booktype;
    private int lendnum;
    private String image;
    private int allnum;
    private String intro;
    private int remainnum;

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBooktype() {
        return booktype;
    }

    public void setBooktype(String booktype) {
        this.booktype = booktype;
    }

    public int getLendnum() {
        return lendnum;
    }

    public void setLendnum(int lendnum) {
        this.lendnum = lendnum;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getAllnum() {
        return allnum;
    }

    public void setAllnum(int allnum) {
        this.allnum = allnum;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getRemainnum() {
        return remainnum;
    }

    public void setRemainnum(int remainnum) {
        this.remainnum = remainnum;
    }
}
