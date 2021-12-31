package com.huiahh.service;

import com.huiahh.pojo.Book;

import java.util.List;

public interface BookService {
    int createBook(Book book);

    int deleteBookById(Integer id);

    int updateBook(Book book);

    List<Book> selectBooks();

    Book selectBookById(Integer id);

    // 模糊
    List<Book> searchBooksByName(String name);

    // 模糊搜索
    List<Book> searchBooksByConditions(Book book);
}
