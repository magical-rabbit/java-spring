package net.dabbit.skd21.exam.autogen.mapper;

import net.dabbit.skd21.exam.autogen.entity.Faculty;

public interface FacultyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Faculty record);

    int insertSelective(Faculty record);

    Faculty selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Faculty record);

    int updateByPrimaryKey(Faculty record);
}