package com.huiahh.controller;

import com.huiahh.pojo.Book;
import com.huiahh.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "",method= RequestMethod.GET)
    @ResponseBody
    public List<Book> bookQuery(@RequestParam String name){
        return bookService.searchBooksByName(name);
    }

    @RequestMapping(value = "/advance",method= RequestMethod.GET)
    @ResponseBody
    public List<Book> bookQueryByConditions(Book book){
        return bookService.searchBooksByConditions(book);
    }

    @RequestMapping(value="",method=RequestMethod.POST)
    @ResponseBody
    public int bookInsert(@RequestBody Book book){
        return bookService.createBook(book);
    }

    @RequestMapping(value="/{bookId}",method=RequestMethod.PUT)
    @ResponseBody
    public int bookUpdate(@RequestBody Book book, @PathVariable Integer bookId){
        return bookService.updateBook(book);
    }

    @RequestMapping(value="/{bookId}",method=RequestMethod.DELETE)
    @ResponseBody
    public int bookDelete(@PathVariable Integer bookId){
        return bookService.deleteBookById(bookId);
    }
}