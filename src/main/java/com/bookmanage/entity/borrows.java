package com.bookmanage.entity;

import java.util.Date;

public class borrows {
    private int borrowid;
    private int userid;
    private Date lendtime;
    private int bookid;
    private int status;

    public int getBorrowid() {
        return borrowid;
    }

    public void setBorrowid(int borrowid) {
        this.borrowid = borrowid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Date getLendtime() {
        return lendtime;
    }

    public void setLendtime(Date lendtime) {
        this.lendtime = lendtime;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
