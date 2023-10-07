package net.dabbit.skd21.exam.controller;

import com.alibaba.fastjson.JSONObject;
import net.dabbit.skd21.exam.utils.ExamGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/exam/")
public class ExamController {

    @RequestMapping(value = "/fetch_list",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String fetch_random_exam(){

        ExamGenerator exam = new ExamGenerator();

        String difficultyProportions = "5:3:1:1";
        int totalQuestions = 28;

        //生成题目
        Map<ExamGenerator.Difficulty, Integer> questionsInDatabase = new HashMap<>();
        questionsInDatabase.put(ExamGenerator.Difficulty.EASY, 35);
        questionsInDatabase.put(ExamGenerator.Difficulty.MEDIUM, 8000);
        questionsInDatabase.put(ExamGenerator.Difficulty.HARD, 6000);
        questionsInDatabase.put(ExamGenerator.Difficulty.VERY_HARD, 3000);
        Map<ExamGenerator.Difficulty, Integer> questionsInPaper = ExamGenerator.calculateQuestionsPerDifficulty(difficultyProportions, totalQuestions);

        //返回函数
        Map<String,List<Integer>> res = new HashMap<>();
        for (ExamGenerator.Difficulty difficulty : ExamGenerator.Difficulty.values()) {
            List<Integer> questionIds = null;
            try {
                questionIds = exam.fetchRandomQuestions(questionsInDatabase.get(difficulty), questionsInPaper.get(difficulty));

            } catch (Exception e) {
                e.printStackTrace();
            }
            res.put(difficulty.name(),questionIds);
//            System.out.println(difficulty.name() + " questions: " + questionIds);
        }
        return JSONObject.toJSONString(res);
    }
}
