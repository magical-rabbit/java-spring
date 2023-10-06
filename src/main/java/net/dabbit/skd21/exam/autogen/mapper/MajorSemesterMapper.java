package net.dabbit.skd21.exam.autogen.mapper;

import net.dabbit.skd21.exam.autogen.entity.MajorSemester;

public interface MajorSemesterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MajorSemester record);

    int insertSelective(MajorSemester record);

    MajorSemester selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MajorSemester record);

    int updateByPrimaryKey(MajorSemester record);
}