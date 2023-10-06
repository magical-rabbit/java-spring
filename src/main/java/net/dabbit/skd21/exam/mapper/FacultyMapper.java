package net.dabbit.skd21.exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.test.emis.entity.Faculty;

import net.dabbit.skd21.exam.entity.JsGridData;

@Mapper
public interface FacultyMapper {
    Long count(JsGridData jsGridData);
    int del(Integer id);
    int add(Faculty faculty);
    int update(Faculty faculty);
    List<Faculty> getAll();
}
