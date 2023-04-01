package com.bookmanage.entity;

import java.util.Date;

public class info {
    private int infoid;
    private int bookid;
    private Date infotime;

    public int getInfoid() {
        return infoid;
    }

    public void setInfoid(int infoid) {
        this.infoid = infoid;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public Date getInfotime() {
        return infotime;
    }

    public void setInfotime(Date infotime) {
        this.infotime = infotime;
    }
}
