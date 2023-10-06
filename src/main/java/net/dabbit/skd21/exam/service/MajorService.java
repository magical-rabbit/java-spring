package net.dabbit.skd21.exam.service;


import net.dabbit.skd21.exam.entity.Major;
import net.dabbit.skd21.exam.entity.JsGridData;
import org.springframework.stereotype.Service;

@Service
public interface MajorService {
    String add(Major major);
    String list(JsGridData jsdata);
    String update(Major major);
    String del(Integer id);
}
