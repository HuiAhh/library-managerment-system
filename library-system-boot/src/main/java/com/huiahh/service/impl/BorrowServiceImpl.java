package com.huiahh.service.impl;

import com.huiahh.dto.BorrowDto;
import com.huiahh.dto.BorrowRentDto;
import com.huiahh.mapper.BorrowMapper;
import com.huiahh.pojo.Book;
import com.huiahh.pojo.Borrow;
import com.huiahh.pojo.Reader;
import com.huiahh.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("borrowService")
public class BorrowServiceImpl implements BorrowService {
    private final BorrowMapper borrowMapper;

    @Autowired
    public BorrowServiceImpl(BorrowMapper borrowMapper) {
        this.borrowMapper = borrowMapper;
    }

    @Override
    public int createBorrowNormally(Book book, Reader reader,Integer returnBorrow) {
        Borrow borrow = new Borrow();
        borrow.setReaderId(reader.getId());
        borrow.setBookId(reader.getId());
        borrow.setReturnBorrow(returnBorrow);
        return borrowMapper.insert(borrow);
    }

    @Override
    public int returnBookByIdCard(BorrowRentDto borrowRentDto) {
        return borrowMapper.updateBorrowByBorrowRentDto(borrowRentDto);
    }

    @Override
    public int insertBorrowByidCard(BorrowRentDto borrowRentDto) {
        borrowRentDto.setBorrowTime(new Date());
        return borrowMapper.insertBorrowByBorrowRentDto(borrowRentDto);
    }

    @Override
    public int createBorrowManually(Borrow borrow) {
        borrow.setBorrowTime(new Date());
        return borrowMapper.insert(borrow);
    }

    @Override
    public int deleteBorrowById(Integer id) {
        return borrowMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateBorrow(Borrow borrow) {
        return borrowMapper.updateByPrimaryKey(borrow);
    }

    @Override
    public List<BorrowDto> selectBorrows() {
        return borrowMapper.selectAll();
    }

    @Override
    public List<BorrowDto> selectBorrowsByConditions(BorrowDto borrow, Date begin, Date end) {
        return borrowMapper.selectByConditions(borrow,begin,end);
    }

    @Override
    public List<BorrowDto> selectBorrowsByBorrowTime(Date begin, Date end) {
        return borrowMapper.selectByBorrowTime(begin,end);
    }

    @Override
    public List<BorrowDto> selectBorrowsByReturnBorrowDate(Date begin, Date end) {
        return borrowMapper.selectBorrowsByReturnBorrowDate(begin,end);
    }

    @Override
    public List<BorrowDto> selectBorrowsByReaderId(String readerId) {
        return borrowMapper.selectBorrowsByReaderId(readerId);
    }

    @Override
    public List<BorrowDto> selectBorrowsByBookId(String bookId) {
        return borrowMapper.selectBorrowsByBookId(bookId);
    }
}
