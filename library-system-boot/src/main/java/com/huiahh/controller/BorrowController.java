package com.huiahh.controller;

import com.huiahh.dto.BorrowDto;
import com.huiahh.dto.BorrowRentDto;
import com.huiahh.pojo.Borrow;
import com.huiahh.service.BorrowService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/borrow")
public class BorrowController {
    private BorrowService borrowService;

    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<BorrowDto> borrowQuery(BorrowDto borrowDto) {
        return borrowService.selectBorrowsByConditions(borrowDto, null, null);
    }

    @RequestMapping(value = "/date", method = RequestMethod.GET)
    public List<BorrowDto> borrowQueryWithDate(BorrowDto borrowDto, Date begin, Date end) {
        return borrowService.selectBorrowsByConditions(borrowDto, begin, end);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public int createBorrow(@RequestBody BorrowRentDto borrow) {
        return borrowService.insertBorrowByidCard(borrow);
    }

    @RequestMapping(value = "/{borrowId}", method = RequestMethod.DELETE)
    public int deleteBorrow(@PathVariable Integer borrowId) {
        return borrowService.deleteBorrowById(borrowId);
    }

    @RequestMapping(value = "/{borrowId}", method = RequestMethod.PUT)
    public int updateBorrow(@RequestBody Borrow borrow, @PathVariable String borrowId) {
        return borrowService.updateBorrow(borrow);
    }

    @RequestMapping(value = "/return", method = RequestMethod.PUT)
    public int returnBook(@RequestBody BorrowRentDto borrow) {
        return borrowService.returnBookByIdCard(borrow);
    }
}
