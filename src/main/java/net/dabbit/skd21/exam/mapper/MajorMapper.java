package net.dabbit.skd21.exam.mapper;

import net.dabbit.skd21.exam.entity.Classes;
import net.dabbit.skd21.exam.entity.JsGridData;
import net.dabbit.skd21.exam.entity.Major;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MajorMapper {

    List<Classes> getByMajorId(Integer majorId);

    List<Major> getByFacultyId(Integer facultyId);

    List<Major> getAllFaculty();

    //11.7 专业管理
    Long count(JsGridData jsGridData);
    int del(Integer id);
    int add(Major major);
    int update(Major major);
    List<Major> list(JsGridData jsGridData);
}
