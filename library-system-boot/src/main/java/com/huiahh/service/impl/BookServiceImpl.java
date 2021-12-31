package com.huiahh.service.impl;

import com.huiahh.mapper.BookMapper;
import com.huiahh.pojo.Book;
import com.huiahh.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("bookService")
public class BookServiceImpl implements BookService {

    private BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int createBook(Book book) {
        return bookMapper.insert(book);
    }

    @Override
    public int deleteBookById(Integer id) {
        return bookMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateBook(Book book) {
        return bookMapper.updateByPrimaryKey(book);
    }

    @Override
    public List<Book> selectBooks() {
        return bookMapper.selectAll();
    }

    @Override
    public Book selectBookById(Integer id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Book> searchBooksByName(String name) {
        return bookMapper.searchByName(name);
    }

    @Override
    public List<Book> searchBooksByConditions(Book book) {
        return bookMapper.searchByConditions(book);
    }
}
