package com.test.emis.mapper;

import com.test.emis.entity.QuestionOptions;

public interface QuestionOptionsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QuestionOptions record);

    int insertSelective(QuestionOptions record);

    QuestionOptions selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QuestionOptions record);

    int updateByPrimaryKey(QuestionOptions record);
}