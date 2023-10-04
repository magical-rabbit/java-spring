package com.test.emis.mapper;

import com.test.emis.entity.QuestionBank;

public interface QuestionBankMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QuestionBank record);

    int insertSelective(QuestionBank record);

    QuestionBank selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QuestionBank record);

    int updateByPrimaryKey(QuestionBank record);
}