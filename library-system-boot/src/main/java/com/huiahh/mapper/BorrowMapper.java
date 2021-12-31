package com.huiahh.mapper;

import com.huiahh.dto.BorrowDto;
import com.huiahh.dto.BorrowRentDto;
import com.huiahh.pojo.Borrow;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface BorrowMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Borrow record);

    BorrowDto selectByPrimaryKey(Integer id);

    List<BorrowDto> selectAll();

    int updateByPrimaryKey(Borrow record);

    List<BorrowDto> selectByConditions(BorrowDto borrow, Date begin, Date end);

    List<BorrowDto> selectByBorrowTime(Date begin, Date end);

    List<BorrowDto> selectBorrowsByReturnBorrowDate(Date begin, Date end);

    List<BorrowDto> selectBorrowsByReaderId(String readerId);

    List<BorrowDto> selectBorrowsByBookId(String bookId);

    int insertBorrowByBorrowRentDto(BorrowRentDto borrowRentDto);

    int updateBorrowByBorrowRentDto(BorrowRentDto borrowRentDto);
}