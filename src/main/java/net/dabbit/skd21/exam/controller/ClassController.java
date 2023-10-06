package net.dabbit.skd21.exam.controller;

import net.dabbit.skd21.exam.entity.JsGridData;

import net.dabbit.skd21.exam.autogen.entity.Class;
import net.dabbit.skd21.exam.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/class")
public class ClassController {

    @Autowired
    ClassService classService;

    @RequestMapping(value = "/getByMajorId",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getByMajorId(Integer majorId){
        String res = classService.getByMajorId(majorId);
        return res;
    }

    @RequestMapping(value = "/getByFacultyId",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getByFacultyId(Integer FacultyId){
        String res = classService.getByFacultyId(FacultyId);
        return res;
    }

    @RequestMapping(value = "/getAllFaculty",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getAllFaculty(){
        String res = classService.getAllFaculty();
        return res;
    }



    @RequestMapping("/list")
    @ResponseBody
    public String list(JsGridData jsdata) {
        return classService.list(jsdata);
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(Class class_) {
        return classService.add(class_);
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(Class class_) {
        return classService.update(class_);
    }

    @RequestMapping("/del")
    @ResponseBody
    public String del(Integer id) {
        return classService.del(id);
    }

}

