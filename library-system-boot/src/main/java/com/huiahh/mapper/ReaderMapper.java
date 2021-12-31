package com.huiahh.mapper;

import com.huiahh.pojo.Reader;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReaderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Reader record);

    Reader selectByPrimaryKey(Integer id);

    List<Reader> selectAll();

    int updateByPrimaryKey(Reader record);

    List<Reader> selectByGender(Integer gender);

    Reader selectByIdCard(String idCard);

    List<Reader> selectByYear(Integer start, Integer end);

    List<Reader> selectByTel(String tel);

    List<Reader> selectByConditions(Reader reader);
}