package net.dabbit.skd21.exam.controller;

import net.dabbit.skd21.exam.autogen.entity.Subject;
import net.dabbit.skd21.exam.entity.JsGridData;
import net.dabbit.skd21.exam.entity.Major;
import net.dabbit.skd21.exam.service.ClassService;
import net.dabbit.skd21.exam.service.MajorService;
import net.dabbit.skd21.exam.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @RequestMapping("/list")
    @ResponseBody
    public String list(JsGridData jsdata) {
        return subjectService.list(jsdata);
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(Subject subject) {
        return subjectService.add(subject);
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(Subject subject) {
        return subjectService.update(subject);
    }

    @RequestMapping("/del")
    @ResponseBody
    public String del(Integer id) {
        return subjectService.del(id);
    }
}

