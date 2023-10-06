package net.dabbit.skd21.exam.service;

import org.springframework.stereotype.Service;

import net.dabbit.skd21.exam.entity.JsGridData;

import net.dabbit.skd21.exam.autogen.entity.Class;

@Service
public interface ClassService {

    String getByMajorId(Integer majorId);

    String getByFacultyId(Integer facultyId);

    String getAllFaculty();


    //11.8.1后端
    String add(Class class_);
    String list(JsGridData jsdata);
    String update(Class class_);
    String del(Integer id);

}
