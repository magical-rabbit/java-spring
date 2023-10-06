package net.dabbit.skd21.exam.autogen.mapper;

import net.dabbit.skd21.exam.autogen.entity.MajorSemester;
import net.dabbit.skd21.exam.autogen.entity.Subject;
import net.dabbit.skd21.exam.entity.JsGridData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MajorSemesterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MajorSemester record);

    int insertSelective(MajorSemester record);

    MajorSemester selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MajorSemester record);

    int updateByPrimaryKey(MajorSemester record);

    Long count(JsGridData jsGridData);
    List<Subject> list(JsGridData jsGridData);
}