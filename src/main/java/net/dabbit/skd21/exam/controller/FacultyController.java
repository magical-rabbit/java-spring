package net.dabbit.skd21.exam.controller;

import net.dabbit.skd21.exam.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    ClassService classService;

    @RequestMapping(value = "/getAllFaculty",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getAllFaculty(){
        String res = classService.getAllFaculty();
        return res;
    }
}


