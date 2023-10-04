package net.dabbit.skd21.exam.controller;


import net.dabbit.skd21.exam.entity.JsGridData;
import net.dabbit.skd21.exam.entity.User;
import net.dabbit.skd21.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    /*
    属性加上了Autowired注解在springboot启动的时候，回去找接口对应的实现类（代理对象）
    * */

    //依赖注入
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login",produces = "application/json; charset=utf-8")
    @ResponseBody
    public  String login(User user){
        String res = userService.login(user);
        return res;
    }


    @RequestMapping(value = "/list",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String list(JsGridData jsdata){
        String res = userService.list(jsdata);
        return res;
    }


    @RequestMapping(value = "/del",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String del(Integer id){
        String res = userService.del(id);
        return res;
    }

    @RequestMapping(value = "/add",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String add(User user){
        String res = userService.add(user);
        return res;
    }

    @RequestMapping(value = "/update",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String update(User user){
        String res = userService.update(user);
        return res;
    }
}
