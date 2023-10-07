package net.dabbit.skd21.exam.controller;


import net.dabbit.skd21.exam.autogen.entity.Role;
import net.dabbit.skd21.exam.autogen.entity.Subject;
import net.dabbit.skd21.exam.entity.JsGridData;
import net.dabbit.skd21.exam.service.RoleService;
import net.dabbit.skd21.exam.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @RequestMapping("/list")
    @ResponseBody
    public String list(JsGridData jsdata) {
        return roleService.list(jsdata);
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(Role role) {
        return roleService.add(role);
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(Role role) {
        return roleService.update(role);
    }

    @RequestMapping("/del")
    @ResponseBody
    public String del(Integer id) {
        return roleService.del(id);
    }
}
