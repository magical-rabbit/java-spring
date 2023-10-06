package net.dabbit.skd21.exam.controller;

import net.dabbit.skd21.exam.entity.Faculty;
import net.dabbit.skd21.exam.entity.JsGridData;
import net.dabbit.skd21.exam.entity.QuestionTemplate;
import net.dabbit.skd21.exam.service.ClassService;
import net.dabbit.skd21.exam.service.FacultyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    ClassService classService;

    @Autowired
    FacultyService facultyService;

    @RequestMapping(value = "/getAllFaculty",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getAllFaculty(){
        String res = classService.getAllFaculty();
        return res;
    }

    @RequestMapping("/list")
    @ResponseBody
    public String list(JsGridData jsdata) {
        return facultyService.list(jsdata);
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(Faculty faculty) {
        return facultyService.add(faculty);
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(Faculty faculty) {
        return facultyService.update(faculty);
    }

    @RequestMapping("/del")
    @ResponseBody
    public String del(Integer id) {
        return facultyService.del(id);
    }
}


