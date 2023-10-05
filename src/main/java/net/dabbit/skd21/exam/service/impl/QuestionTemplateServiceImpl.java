package net.dabbit.skd21.exam.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import net.dabbit.skd21.exam.entity.JsGridData;
import net.dabbit.skd21.exam.entity.QuestionTemplate;
import net.dabbit.skd21.exam.mapper.QuestionTemplateMapper;
import net.dabbit.skd21.exam.service.QuestionTemplateService;


@Service
public class QuestionTemplateServiceImpl implements QuestionTemplateService{

    @Autowired
    QuestionTemplateMapper questionTemplateMapper;

    @Override
    public String add(QuestionTemplate questionTemplate) {
        Map<String,String> msg = new HashMap<String,String>();
        msg.put("msg","2333");

        int add_ = questionTemplateMapper.add(questionTemplate);
        if(add_>0){
            msg.put("code","200");
        }else{
            msg.put("code","401");
            msg.put("info", "添加失败,修改条数小于1");
        }
        return JSONObject.toJSONString(msg);
    }

    @Override
    public String list(JsGridData jsdata) {
        Long cnt = questionTemplateMapper.count(jsdata);
        List<QuestionTemplate> list = questionTemplateMapper.list(jsdata);

        //设置数据，设置列表数量
        jsdata.setData(list);
        jsdata.setItemsCount(cnt);

        //返回数据

        return JSONObject.toJSONString(jsdata);
    }

    @Override
    public String update(QuestionTemplate questionTemplate) {

        Map<String,String> msg = new HashMap<String,String>();
        msg.put("msg","2333");
        int update_ = questionTemplateMapper.update(questionTemplate);
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
        int del_ = questionTemplateMapper.del(id);
        if(del_>0){
            msg.put("code","200");
        }else{
            msg.put("code","401");
            msg.put("info", "删除失败,修改条数小于1");
        }
        return JSONObject.toJSONString(msg);
    }

}
