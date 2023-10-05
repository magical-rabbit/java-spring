package net.dabbit.skd21.exam.service;


import net.dabbit.skd21.exam.entity.QuestionTemplate;
import net.dabbit.skd21.exam.entity.JsGridData;
import org.springframework.stereotype.Service;

@Service
public interface QuestionTemplateService {
    String add(QuestionTemplate questionTemplate);
    String list(JsGridData jsdata);
    String update(QuestionTemplate questionTemplate);
    String del(Integer id);
}
