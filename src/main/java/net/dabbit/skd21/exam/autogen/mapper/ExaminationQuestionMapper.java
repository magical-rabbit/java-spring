package net.dabbit.skd21.exam.autogen.mapper;

import net.dabbit.skd21.exam.autogen.entity.ExaminationQuestion;

public interface ExaminationQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExaminationQuestion record);

    int insertSelective(ExaminationQuestion record);

    ExaminationQuestion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExaminationQuestion record);

    int updateByPrimaryKey(ExaminationQuestion record);
}