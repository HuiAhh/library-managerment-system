package com.huiahh.service;

import com.huiahh.dto.BorrowDto;
import com.huiahh.dto.BorrowRentDto;
import com.huiahh.pojo.Admin;
import com.huiahh.pojo.Book;
import com.huiahh.pojo.Borrow;
import com.huiahh.pojo.Reader;

import java.util.Date;
import java.util.List;

public interface BorrowService {
    int createBorrowNormally(Book book, Reader reader,Integer returnBorrow);

    int createBorrowManually(Borrow borrow);

    int deleteBorrowById(Integer id);

    int updateBorrow(Borrow borrow);

    List<BorrowDto> selectBorrows();

    List<BorrowDto> selectBorrowsByConditions(BorrowDto borrow, Date begin, Date end);

    List<BorrowDto> selectBorrowsByBorrowTime(Date begin, Date end);

    List<BorrowDto> selectBorrowsByReturnBorrowDate(Date begin, Date end);

    List<BorrowDto> selectBorrowsByReaderId(String readerId);

    List<BorrowDto> selectBorrowsByBookId(String bookId);

    int insertBorrowByidCard(BorrowRentDto borrowRentDto);

    int returnBookByIdCard(BorrowRentDto borrowRentDto);
}
