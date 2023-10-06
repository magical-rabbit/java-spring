package net.dabbit.skd21.exam.service;


import net.dabbit.skd21.exam.entity.Faculty;
import net.dabbit.skd21.exam.entity.JsGridData;
import org.springframework.stereotype.Service;

@Service
public interface FacultyService {
    String add(Faculty faculty);
    String list(JsGridData jsdata);
    String update(Faculty faculty);
    String del(Integer id);
}
