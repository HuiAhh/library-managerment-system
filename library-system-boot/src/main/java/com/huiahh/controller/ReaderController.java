package com.huiahh.controller;

import com.huiahh.pojo.Reader;
import com.huiahh.service.ReaderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reader")
public class ReaderController {
    private ReaderService readerService;

    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<Reader> readerQuery(Reader reader){
        return readerService.selectReadersByConditions(reader);
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public int readerRegister(@RequestBody Reader reader){
        return readerService.createReader(reader);
    }

    @RequestMapping(value = "/{readerId}",method = RequestMethod.PUT)
    public int readerModify(@RequestBody Reader reader, @PathVariable Integer readerId){
        return readerService.updateReader(reader);
    }

    @RequestMapping(value = "/{readerId}",method = RequestMethod.DELETE)
    public int deleteReader(@PathVariable Integer readerId){
        return readerService.deleteReadeById(readerId);
    }
}
