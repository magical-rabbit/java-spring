package net.dabbit.skd21.exam.autogen.mapper;

import net.dabbit.skd21.exam.autogen.entity.QuestionBank;

public interface QuestionBankMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QuestionBank record);

    int insertSelective(QuestionBank record);

    QuestionBank selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QuestionBank record);

    int updateByPrimaryKey(QuestionBank record);
}