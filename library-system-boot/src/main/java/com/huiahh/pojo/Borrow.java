package com.huiahh.pojo;

import java.util.Date;

public class Borrow {
    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", readerId=" + readerId +
                ", bookId=" + bookId +
                ", borrowTime=" + borrowTime +
                ", returnBorrow=" + returnBorrow +
                '}';
    }

    private Integer id;
    private Integer readerId;
    private Integer bookId;
    private Date borrowTime;
    private Integer returnBorrow;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Date getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Date borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Integer getReturnBorrow() {
        return returnBorrow;
    }

    public void setReturnBorrow(Integer returnBorrow) {
        this.returnBorrow = returnBorrow;
    }
}