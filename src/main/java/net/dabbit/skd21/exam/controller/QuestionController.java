package net.dabbit.skd21.exam.controller;

import java.io.InputStream;
import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.dabbit.skd21.exam.entity.Question;
import net.dabbit.skd21.exam.entity.QuestionOption;
import net.dabbit.skd21.exam.utils.PoiUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;


import net.dabbit.skd21.exam.service.QuestionService;

@Controller
@RequestMapping("/test")
public class QuestionController {

//    @Autowired
//    QuestionService questionService;

    @Autowired
    HttpServletRequest request; //自动注入request

    @Autowired
    QuestionService questionService;

    @RequestMapping("/getbyid")
    @ResponseBody
    public String get_question_by_id(Integer id){
        return questionService.getQuestionById(id);
    }

    @RequestMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile questonFile) throws Exception{
        // 上传文件
        String fileName = questonFile.getOriginalFilename();
        System.out.println("------" + fileName);
        // 得到上传文件的流
        InputStream in = questonFile.getInputStream();
        // 读取Excel，返回list集合
        List<Map<String, Object>> list = PoiUtil.readExcel(in);


        int res_question_cnt = 0;
        int res_question_opt_cnt =0;


        for(Map<String, Object> map : list){
            //加进来
            Question question = new Question();
            question.setAnswer((String) map.get("answer"));//答案
            question.setQuestionCode((String) map.get("questionCode"));
            question.setQuestionName((String) map.get("q_name"));

            String difficultyString = (String) map.get("diff");
            if (difficultyString != null) {
                try {
                    int difficulty = Integer.parseInt(difficultyString);
                    question.setDifficulty(difficulty);
                } catch (NumberFormatException e) {
                    // Handle the error if the string isn't a valid integer representation
                    e.printStackTrace();
                }
            }

            List<QuestionOption> questionOptions = new ArrayList<>();

            if (map.containsKey("options") && map.get("options") instanceof Object[]) {
                Object[] optionsArray = (Object[]) map.get("options");
                for (int i = 0; i < 4 && i < optionsArray.length; ++i) {
                    if (optionsArray[i] instanceof String) {
                        String opt = (String) optionsArray[i];
                        if (opt != null && opt.split(" ").length > 1) {
                            QuestionOption qs = new QuestionOption();
                            qs.setQuestionCode(question.getQuestionCode());
                            qs.setOptionsCode(String.valueOf((char) ('A' + i)));
                            qs.setOptionsText(opt.split(" ")[1]);
                            questionOptions.add(qs);
                        }
                    }
                }
            }



            int res = 0;

            res += questionService.addQuestionList(Collections.singletonList(question));  //保存问题
            res += questionService.addQuestionOptionsList(questionOptions);  //保存选项

            if(res==2) {
                res_question_cnt++;
                res_question_opt_cnt++;
            }
        }

        System.out.println("qType: " + request.getParameter("qType"));
        System.out.println("subject: " + request.getParameter("subject"));

        return "<script>" +
                "alert('上传成功');" +"添加了:"+res_question_cnt+"个问题"+
                "window.opener=null;" +
                "window.open('','_self');" +
                "window.close();" +
                "</script>";
    }
}
