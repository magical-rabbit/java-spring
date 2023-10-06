package net.dabbit.skd21.exam.autogen.mapper;

import net.dabbit.skd21.exam.autogen.entity.QuestionOptions;

public interface QuestionOptionsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QuestionOptions record);

    int insertSelective(QuestionOptions record);

    QuestionOptions selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QuestionOptions record);

    int updateByPrimaryKey(QuestionOptions record);
}