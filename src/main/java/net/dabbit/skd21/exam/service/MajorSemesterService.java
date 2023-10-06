package net.dabbit.skd21.exam.service;


import net.dabbit.skd21.exam.entity.JsGridData;
import org.springframework.stereotype.Service;


import net.dabbit.skd21.exam.autogen.entity.MajorSemester;

@Service
public interface MajorSemesterService {
    String add(MajorSemester majorSemester);
    String list(JsGridData jsdata);
    String update(MajorSemester majorSemester);
    String del(Integer id);
}
