package net.dabbit.skd21.exam.controller;

import net.dabbit.skd21.exam.entity.Faculty;
import net.dabbit.skd21.exam.entity.JsGridData;
import net.dabbit.skd21.exam.entity.Major;
import net.dabbit.skd21.exam.service.ClassService;
import net.dabbit.skd21.exam.service.FacultyService;
import net.dabbit.skd21.exam.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/major")
public class MajorController {

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


    @Autowired
    MajorService majorService;

    @RequestMapping("/list")
    @ResponseBody
    public String list(JsGridData jsdata) {
        return majorService.list(jsdata);
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(Major major) {
        return majorService.add(major);
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(Major major) {
        return majorService.update(major);
    }

    @RequestMapping("/del")
    @ResponseBody
    public String del(Integer id) {
        return majorService.del(id);
    }
}

