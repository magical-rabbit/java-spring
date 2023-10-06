package net.dabbit.skd21.exam.autogen.mapper;

import net.dabbit.skd21.exam.autogen.entity.Major;

public interface MajorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Major record);

    int insertSelective(Major record);

    Major selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);
}