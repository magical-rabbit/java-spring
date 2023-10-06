package net.dabbit.skd21.exam.controller;

import net.dabbit.skd21.exam.autogen.entity.MajorSemester;
import net.dabbit.skd21.exam.autogen.entity.Subject;
import net.dabbit.skd21.exam.autogen.mapper.MajorSemesterMapper;
import net.dabbit.skd21.exam.entity.JsGridData;
import net.dabbit.skd21.exam.service.MajorSemesterService;
import net.dabbit.skd21.exam.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/major-semester")
public class MajorSemesterController {
    @Autowired
    MajorSemesterService majorSemesterService;

    @RequestMapping("/list")
    @ResponseBody
    public String list(JsGridData jsdata) {
        return majorSemesterService.list(jsdata);
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(MajorSemester majorSemester) {
        return majorSemesterService.add(majorSemester);
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(MajorSemester majorSemester) {
        return majorSemesterService.update(majorSemester);
    }

    @RequestMapping("/del")
    @ResponseBody
    public String del(Integer id) {
        return majorSemesterService.del(id);
    }
}

