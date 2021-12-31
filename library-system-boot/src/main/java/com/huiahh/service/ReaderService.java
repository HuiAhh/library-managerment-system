package com.huiahh.service;

import com.huiahh.pojo.Reader;

import java.util.List;

public interface ReaderService {
    int createReader(Reader reader);

    int deleteReadeById(Integer id);

    int updateReader(Reader reader);

    Reader selectReaderById(Integer id);

    List<Reader> selectReaders();

    List<Reader> selectReadersByConditions(Reader reader);

    List<Reader> selectReadersByGender(Integer gender);

    Reader selectReadersByIdCard(String idCard);

    List<Reader> selectReadersByYear(Integer start, Integer end);

    List<Reader> selectReadersByTel(String tel);
}
