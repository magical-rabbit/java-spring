package net.dabbit.skd21.exam.service;


import net.dabbit.skd21.exam.entity.JsGridData;
import net.dabbit.skd21.exam.entity.Major;
import org.springframework.stereotype.Service;


import net.dabbit.skd21.exam.autogen.entity.Subject;

@Service
public interface SubjectService {
    String add(Subject subject);
    String list(JsGridData jsdata);
    String update(Subject subject);
    String del(Integer id);
}
