package net.dabbit.skd21.exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.dabbit.skd21.exam.entity.Faculty;
import net.dabbit.skd21.exam.entity.JsGridData;

@Mapper
public interface FacultyMapper {
    Long count(JsGridData jsGridData);
    int del(Integer id);
    int add(Faculty faculty);
    int update(Faculty faculty);
    List<Faculty> list(JsGridData jsGridData);

//    int add(net.dabbit.skd21.exam.entity.Faculty faculty);
}
