package com.huiahh.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class BorrowDto {
    private Integer id;
    private Integer readerId;
    private String readerName;
    private Integer bookId;
    private String bookName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date borrowTime;
    private Integer returnBorrow;

    @Override
    public String toString() {
        return "BorrowDto{" +
                "id=" + id +
                ", readerId=" + readerId +
                ", readerName='" + readerName + '\'' +
                ", bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", borrowTime=" + borrowTime +
                ", returnBorrow=" + returnBorrow +
                '}';
    }

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

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
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
