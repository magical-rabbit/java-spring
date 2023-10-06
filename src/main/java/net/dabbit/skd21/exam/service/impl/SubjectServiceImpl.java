package net.dabbit.skd21.exam.service.impl;

import com.alibaba.fastjson.JSONObject;
import net.dabbit.skd21.exam.autogen.entity.Subject;
import net.dabbit.skd21.exam.autogen.mapper.SubjectMapper;
import net.dabbit.skd21.exam.entity.JsGridData;
import net.dabbit.skd21.exam.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectMapper subjectMapper;

    @Override
    public String add(Subject subject) {
        Map<String,String> msg = new HashMap<String,String>();
        msg.put("msg","2333");
        int add_ = subjectMapper.insertSelective(subject);
        if(add_>0){
            msg.put("code","200");
        }else{
            msg.put("code", "401");
            msg.put("info", "添加失败,修改条数小于1");
        }
        return JSONObject.toJSONString(msg);
    }

    @Override
    public String update(Subject subject) {
        Map<String,String> msg = new HashMap<String,String>();
        msg.put("msg","2333");
        int add_ = subjectMapper.updateByPrimaryKeySelective(subject);
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
        Long cnt = subjectMapper.count(jsdata);
        List<Subject> list = subjectMapper.list(jsdata);

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
        int del_ = subjectMapper.deleteByPrimaryKey(id);
        if(del_>0){
            msg.put("code","200");
        }else{
            msg.put("code","401");
            msg.put("info", "删除失败,修改条数小于1");
        }
        return JSONObject.toJSONString(msg);
    }
}
