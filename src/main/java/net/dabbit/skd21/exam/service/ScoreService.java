package net.dabbit.skd21.exam.service;

import net.dabbit.skd21.exam.autogen.entity.Score;
import net.dabbit.skd21.exam.entity.JsGridData;
import net.dabbit.skd21.exam.entity.QuestionTemplate;

import org.springframework.stereotype.Service;

@Service
public interface ScoreService {
    String query(int user_id,int subject_id);
    
    
    String add(Score score);
    String list(JsGridData jsdata);
    String update(Score score);
    String del(Integer id);
}
