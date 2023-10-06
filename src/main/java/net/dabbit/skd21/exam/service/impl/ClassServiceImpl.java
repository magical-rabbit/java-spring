package net.dabbit.skd21.exam.service.impl;


import com.alibaba.fastjson.JSONObject;

import net.dabbit.skd21.exam.autogen.entity.Class;
import net.dabbit.skd21.exam.entity.Classes;
import net.dabbit.skd21.exam.entity.JsGridData;
import net.dabbit.skd21.exam.entity.Major;
import net.dabbit.skd21.exam.mapper.ClassMapper;
import net.dabbit.skd21.exam.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    ClassMapper classMapper;

    @Override
    public String getByMajorId(Integer majorId) {
        List<Classes> list = classMapper.getByMajorId(majorId);
//
//        Map<String,String> msg = new HashMap<>();
//        msg.put("msg","999");
//        if(list != null){
//            msg.put("code","200");
//            msg.put(list.);
//        }
        return JSONObject.toJSONString(list);

    }

    @Override
    public String getByFacultyId(Integer facultyId) {
        List<Major> list = classMapper.getByFacultyId(facultyId);
        return JSONObject.toJSONString(list);
    }

    @Override
    public String getAllFaculty() {
        List<Major> list = classMapper.getAllFaculty();
        return JSONObject.toJSONString(list);
    }


    //11.8.1后端

    @Override
    public String add(Class class_) {
        Map<String,String> msg = new HashMap<String,String>();
        msg.put("msg","2333");
        int add_ = classMapper.add(class_);
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
        Long cnt = classMapper.count(jsdata);
        List<Class> list = classMapper.list(jsdata);

        //设置数据，设置列表数量
        jsdata.setData(list);
        jsdata.setItemsCount(cnt);

        //返回数据

        return JSONObject.toJSONString(jsdata);
    }

    @Override
    public String update(Class class_) {

        Map<String,String> msg = new HashMap<String,String>();
        msg.put("msg","2333");
        int update_ = classMapper.update(class_);
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
        int del_ = classMapper.del(id);
        if(del_>0){
            msg.put("code","200");
        }else{
            msg.put("code","401");
            msg.put("info", "删除失败,修改条数小于1");
        }
        return JSONObject.toJSONString(msg);
    }
}
