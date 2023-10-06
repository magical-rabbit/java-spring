package net.dabbit.skd21.exam.service.impl;

import com.alibaba.fastjson.JSONObject;
import net.dabbit.skd21.exam.entity.JsGridData;
import net.dabbit.skd21.exam.entity.Question;
import net.dabbit.skd21.exam.entity.QuestionOption;
import net.dabbit.skd21.exam.mapper.QuestionMapper;
import net.dabbit.skd21.exam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionMapper questionMapper;


    @Override
    public int addQuestionList(List<Question> list) {

        Map<String,String> msg = new HashMap<String,String>();
        msg.put("msg","2333");
        try {
            questionMapper.addQuestionList(list);
        } catch (Exception e) {
            e.printStackTrace();
            return  0 ;
        }
        return 1;
    }

    @Override
    public int addQuestionOptionsList(List<QuestionOption> list) {
        try {
            questionMapper.addQuestionOptionsList(list);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


    @Override
    public String getQuestionList(JsGridData jsGridData) {
        List<Question> ls = questionMapper.getQuestionList(jsGridData);
        return JSONObject.toJSONString(ls);
    }

    @Override
    public String getOptionsForQuestion(Question question) {
        List<QuestionOption> ls = questionMapper.getOptionsForQuestion(question);
        return JSONObject.toJSONString(ls);
    }
}
