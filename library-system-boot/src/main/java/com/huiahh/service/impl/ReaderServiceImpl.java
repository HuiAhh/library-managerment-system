package com.huiahh.service.impl;

import com.huiahh.mapper.ReaderMapper;
import com.huiahh.pojo.Reader;
import com.huiahh.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("readerService")
public class ReaderServiceImpl implements ReaderService {
    private final ReaderMapper readerMapper;

    @Autowired
    public ReaderServiceImpl(ReaderMapper readerMapper) {
        this.readerMapper = readerMapper;
    }

    @Override
    public int createReader(Reader reader) {
        return readerMapper.insert(reader);
    }

    @Override
    public int deleteReadeById(Integer id) {
        return readerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateReader(Reader reader) {
        return readerMapper.updateByPrimaryKey(reader);
    }

    @Override
    public Reader selectReaderById(Integer id) {
        return readerMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Reader> selectReaders() {
        return readerMapper.selectAll();
    }

    @Override
    public List<Reader> selectReadersByConditions(Reader reader) {
        return readerMapper.selectByConditions(reader);
    }

    @Override
    public List<Reader> selectReadersByGender(Integer gender) {
        return readerMapper.selectByGender(gender);
    }

    @Override
    public Reader selectReadersByIdCard(String idCard) {
        return readerMapper.selectByIdCard(idCard);
    }

    @Override
    public List<Reader> selectReadersByYear(Integer start, Integer end) {
        return readerMapper.selectByYear(start,end);
    }

    @Override
    public List<Reader> selectReadersByTel(String tel) {
        return readerMapper.selectByTel(tel);
    }
}
