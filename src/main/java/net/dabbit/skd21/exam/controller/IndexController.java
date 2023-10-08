package net.dabbit.skd21.exam.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    /*
    属性加上了Autowired注解在springboot启动的时候，回去找接口对应的实现类（代理对象）
    * */

    //依赖注入
    @RequestMapping(value = "/")
    @ResponseBody
    public String index(){
       //重定向到pape/index.html
//        return "redirect:/page/index.html";
        return "<script>window.location.href = '/pages/login" +
                ".html';</script>";
////        return "redirect:pages/login.html";
    }
}
