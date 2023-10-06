package net.dabbit.skd21.exam.mapper;

import net.dabbit.skd21.exam.entity.Classes;
import net.dabbit.skd21.exam.entity.JsGridData;
import net.dabbit.skd21.exam.entity.Major;
import org.apache.ibatis.annotations.Mapper;

import net.dabbit.skd21.exam.autogen.entity.Class;

import java.util.List;

@Mapper
public interface ClassMapper {

    List<Classes> getByMajorId(Integer majorId);

    List<Major> getByFacultyId(Integer facultyId);

    List<Major> getAllFaculty();

    Long count(JsGridData jsGridData);
    int del(Integer id);
    int add(Class class_);
    int update(Class class_);
    List<Class> list(JsGridData jsGridData);

}
