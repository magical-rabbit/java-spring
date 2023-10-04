package net.dabbit.skd21.exam.controller;


import net.dabbit.skd21.exam.entity.JsGridData;
import net.dabbit.skd21.exam.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/menu")
public class MemuController {
    @Autowired
    MenuService menuService;


    @RequestMapping(value = "/list-all",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getList(JsGridData jsGridData){
        String res = menuService.list(jsGridData);
        return res;
    }
    // ----------------------------------
    /*
    * 1、controller接收JSGrid请求参数
        String pageSize = request.getParameter("pageSize");
        String pageIndex = request.getParameter("pageIndex");

       2、controller返回json格式
    {
        "data" : 数据集合,
        "itemsCount" : 总条数
     }
    * */
    @RequestMapping(value = "/list",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String list(JsGridData jsGridData){
        String res = menuService.list(jsGridData);
        return res;
    }

    @RequestMapping(value = "/add",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String add(JsGridData jsGridData){
        String res = menuService.add(jsGridData);
        return res;
    }
}
