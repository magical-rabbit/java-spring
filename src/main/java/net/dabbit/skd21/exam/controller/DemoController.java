package net.dabbit.skd21.exam.controller;

import net.dabbit.skd21.exam.entity.DemoEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class DemoController {
    /*
    * localhost:8080/demo/index
    * */
    @RequestMapping("/index")
    @ResponseBody // 返回值是一 个具体的值（非路径）
    public String index(){
        return "你好";
    }

    /*
    * name
    * age
    * */
    @RequestMapping("/add")
    @ResponseBody // 返回值是一 个具体的值（非路径）
    public String add(String name,Integer age){
        return name + ","+age;
    }

    /*
     * 实体类对象
     * 实体名
     * */
    @RequestMapping("/add1")
    @ResponseBody // 返回值是一 个具体的值（非路径）
    public String add1(DemoEntity demoEntity){
        return demoEntity.getName()+"--"+demoEntity.getAge();
    }
}
