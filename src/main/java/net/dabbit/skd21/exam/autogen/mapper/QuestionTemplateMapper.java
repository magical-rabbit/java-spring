package net.dabbit.skd21.exam.autogen.mapper;

import net.dabbit.skd21.exam.autogen.entity.QuestionTemplate;

public interface QuestionTemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QuestionTemplate record);

    int insertSelective(QuestionTemplate record);

    QuestionTemplate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QuestionTemplate record);

    int updateByPrimaryKey(QuestionTemplate record);
}