package com.test.emis.mapper;

import com.test.emis.entity.MajorSemesterSubject;

public interface MajorSemesterSubjectMapper {
    int insert(MajorSemesterSubject record);

    int insertSelective(MajorSemesterSubject record);
}