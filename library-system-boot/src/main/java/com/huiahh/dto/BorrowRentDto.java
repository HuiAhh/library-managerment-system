package com.huiahh.dto;

import java.util.Date;

public class BorrowRentDto {
    private Integer bookId;
    private Integer returnBorrow;
    private String idCard;
    private Date borrowTime;

    @Override
    public String toString() {
        return "BorrowRentDto{" +
                "bookId=" + bookId +
                ", returnBorrow=" + returnBorrow +
                ", idCard='" + idCard + '\'' +
                ", borrowTime=" + borrowTime +
                '}';
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
}
