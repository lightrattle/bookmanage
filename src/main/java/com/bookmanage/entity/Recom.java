package com.bookmanage.entity;

public class Recom {
    private int recomid;
    private int userid;
    private String major;
    private String develop;
    private int bookid;

    private String reason;

    public int getRecomid() {
        return recomid;
    }

    public void setRecomid(int recomid) {
        this.recomid = recomid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDevelop() {
        return develop;
    }

    public void setDevelop(String develop) {
        this.develop = develop;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
