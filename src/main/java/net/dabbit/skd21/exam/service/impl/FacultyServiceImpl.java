package net.dabbit.skd21.exam.service.impl;

import java.util.HashMap;
import java.util.Map;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import net.dabbit.skd21.exam.mapper.FacultyMapper;
import net.dabbit.skd21.exam.entity.Faculty;
import net.dabbit.skd21.exam.entity.JsGridData;
import net.dabbit.skd21.exam.service.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    FacultyMapper facultyMapper;

    @Override
    public String add(Faculty faculty) {
        Map<String,String> msg = new HashMap<String,String>();
        msg.put("msg","2333");
        int add_ = facultyMapper.add(faculty);
        if(add_>0){
            msg.put("code","200");
        }else{
            msg.put("code", "401");
            msg.put("info", "添加失败,修改条数小于1");
        }
        return JSONObject.toJSONString(msg);
    }

    @Override
    public String list(JsGridData jsdata) {
       Long cnt = facultyMapper.count(jsdata);
        List<Faculty> list = facultyMapper.list(jsdata);

        //设置数据，设置列表数量
        jsdata.setData(list);
        jsdata.setItemsCount(cnt);

        //返回数据

        return JSONObject.toJSONString(jsdata);
    }

    @Override
    public String update(Faculty faculty) {
       
        Map<String,String> msg = new HashMap<String,String>();
        msg.put("msg","2333");
        int update_ = facultyMapper.update(faculty);
        if(update_>0){
            msg.put("code","200");
        }else{
            msg.put("code","401");
            msg.put("info", "修改失败,修改条数小于1");
        }
        return JSONObject.toJSONString(msg);
    }

    @Override
    public String del(Integer id) {
        Map<String,String> msg = new HashMap<String,String>();
        msg.put("msg","2333");
        int del_ = facultyMapper.del(id);
        if(del_>0){
            msg.put("code","200");
        }else{
            msg.put("code","401");
            msg.put("info", "删除失败,修改条数小于1");
        }
        return JSONObject.toJSONString(msg);
    }
    
}
