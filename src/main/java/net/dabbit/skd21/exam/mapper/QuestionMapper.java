package net.dabbit.skd21.exam.mapper;

import net.dabbit.skd21.exam.entity.JsGridData;
import net.dabbit.skd21.exam.entity.Question;
import net.dabbit.skd21.exam.entity.QuestionOption;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionMapper {
    int addQuestionList(List<Question> list);
    int addQuestionOptionsList(List<QuestionOption> list);
    List<Question> getQuestionList(JsGridData jsGridData);
    List<QuestionOption> getOptionsForQuestion(Question question);
}
