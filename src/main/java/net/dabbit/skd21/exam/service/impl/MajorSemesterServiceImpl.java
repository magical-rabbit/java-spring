package net.dabbit.skd21.exam.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;

import net.dabbit.skd21.exam.autogen.entity.MajorSemester;
import net.dabbit.skd21.exam.autogen.entity.Subject;
import net.dabbit.skd21.exam.autogen.mapper.MajorSemesterMapper;
import net.dabbit.skd21.exam.entity.JsGridData;
import net.dabbit.skd21.exam.service.MajorSemesterService;
import org.springframework.stereotype.Service;

@Service
public class MajorSemesterServiceImpl implements MajorSemesterService {

    @Autowired
    MajorSemesterMapper majorSemesterMapper;
    
    @Override
    public String add(MajorSemester majorSemester) {
        Map<String,String> msg = new HashMap<String,String>();
        msg.put("msg","2333");
        int add_ = majorSemesterMapper.insertSelective(majorSemester);
        if(add_>0){
            msg.put("code","200");
        }else{
            msg.put("code", "401");
            msg.put("info", "添加失败,修改条数小于1");
        }
        return JSONObject.toJSONString(msg);
    }

    @Override
    public String update(MajorSemester majorSemester) {
        Map<String,String> msg = new HashMap<String,String>();
        msg.put("msg","2333");
        int add_ = majorSemesterMapper.updateByPrimaryKeySelective(majorSemester);
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
        Long cnt = majorSemesterMapper.count(jsdata);
        List<Subject> list = majorSemesterMapper.list(jsdata);

        //设置数据，设置列表数量
        jsdata.setData(list);
        jsdata.setItemsCount(cnt);
        //返回数据
        return JSONObject.toJSONString(jsdata);
    }



    @Override
    public String del(Integer id) {
        Map<String,String> msg = new HashMap<String,String>();
        msg.put("msg","2333");
        int del_ = majorSemesterMapper.deleteByPrimaryKey(id);
        if(del_>0){
            msg.put("code","200");
        }else{
            msg.put("code","401");
            msg.put("info", "删除失败,修改条数小于1");
        }
        return JSONObject.toJSONString(msg);
    }
    
}
