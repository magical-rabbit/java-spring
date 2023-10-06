package net.dabbit.skd21.exam.service;

import net.dabbit.skd21.exam.entity.JsGridData;
import net.dabbit.skd21.exam.entity.Question;
import net.dabbit.skd21.exam.entity.QuestionOption;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {
    int addQuestionList(List<Question> list);
    int addQuestionOptionsList(List<QuestionOption> list);
    String getQuestionList(JsGridData jsGridData);
    String getOptionsForQuestion(Question question);
}
