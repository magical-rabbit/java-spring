package net.dabbit.skd21.exam.controller;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import net.dabbit.skd21.exam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.dabbit.skd21.exam.entity.Question;
import net.dabbit.skd21.exam.entity.QuestionOption;
import net.dabbit.skd21.exam.utils.PoiUtil;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/test")
public class ExamController {

    @Autowired
    QuestionService questionService;

    @Autowired
    HttpServletRequest request; //自动注入request




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
            Question question = (Question) map.get("questions");
            List<QuestionOption> questionOptions = (List<QuestionOption>) map.get("questionOptions");

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
