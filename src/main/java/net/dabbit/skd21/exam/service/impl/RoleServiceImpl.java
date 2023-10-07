package net.dabbit.skd21.exam.service.impl;


import com.alibaba.fastjson.JSONObject;
import net.dabbit.skd21.exam.autogen.entity.Role;
import net.dabbit.skd21.exam.autogen.mapper.RoleMapper;
import net.dabbit.skd21.exam.entity.JsGridData;
import net.dabbit.skd21.exam.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl  implements  RoleService{
    @Autowired
    RoleMapper roleMapper;


    @Override
    public String add(Role role) {
        Map<String,String> msg = new HashMap<String,String>();
        msg.put("msg","2333");
        int add_ = roleMapper.insertSelective(role);
        if(add_>0){
            msg.put("code","200");
        }else{
            msg.put("code", "401");
            msg.put("info", "添加失败,修改条数小于1");
        }
        return JSONObject.toJSONString(msg);
    }

    @Override
    public String update(Role role) {
        Map<String,String> msg = new HashMap<String,String>();
        msg.put("msg","2333");
        int add_ = roleMapper.updateByPrimaryKeySelective(role);
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
        Long cnt = roleMapper.count(jsdata);
        List<Role> list = roleMapper.list(jsdata);

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
        int del_ = roleMapper.deleteByPrimaryKey(id);
        if(del_>0){
            msg.put("code","200");
        }else{
            msg.put("code","401");
            msg.put("info", "删除失败,修改条数小于1");
        }
        return JSONObject.toJSONString(msg);
    }
}
