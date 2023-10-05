package net.dabbit.skd21.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.dabbit.skd21.exam.entity.JsGridData;
import net.dabbit.skd21.exam.entity.QuestionTemplate;
import net.dabbit.skd21.exam.service.QuestionTemplateService;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/questionTemplate")
public class QuestionTemplateController {
    @Autowired 
    QuestionTemplateService questionTemplateService;

    @RequestMapping("/list")
    @ResponseBody
    public String list(JsGridData jsdata) {
       return questionTemplateService.list(jsdata);
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(QuestionTemplate questionTemplate) {
        return questionTemplateService.add(questionTemplate);
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(QuestionTemplate questionTemplate) {
        return questionTemplateService.update(questionTemplate);
    }

    @RequestMapping("/del")
    @ResponseBody
    public String del(Integer id) {
        return questionTemplateService.del(id);
    }
}
