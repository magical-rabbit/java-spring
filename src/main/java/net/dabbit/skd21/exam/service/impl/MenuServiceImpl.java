package net.dabbit.skd21.exam.service.impl;

import com.alibaba.fastjson.JSONObject;
import net.dabbit.skd21.exam.entity.JsGridData;
import net.dabbit.skd21.exam.entity.Menu;
import net.dabbit.skd21.exam.mapper.MenuMapper;
import net.dabbit.skd21.exam.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService{
    @Autowired
    MenuMapper menuMapper;

    @Override
    public String list(JsGridData jsGridData) {
        List<Menu> ls = menuMapper.list(jsGridData);
        Long cnt = menuMapper.count(jsGridData);
        jsGridData.setItemsCount(cnt);
        jsGridData.setData(ls);
        return JSONObject.toJSONString(jsGridData);
    }

    @Override
    public String add(Menu menu) {
        int add_ = menuMapper.add(menu);
        Map<String,String> msg = new HashMap<>();
        msg.put("msg","999");

        if(add_>0){
            msg.put("code","200");
        }

        return JSONObject.toJSONString(msg);
    }

    @Override
    public String del(Integer id) {
        int del_ = menuMapper.delByPrimaryKey(id);
        Map<String,String> msg = new HashMap<>();
        msg.put("msg","2333");
        //如果大于0表示添加成功
        if(del_>0){
            msg.put("code","200");
        }
        return JSONObject.toJSONString(msg);
    }

    @Override
    public String modify(Menu menu) {
        int update_ = menuMapper.updateByPrimaryKeySelective(menu);
        Map<String,String> msg = new HashMap<>();
        msg.put("msg","2333");

        if(update_>0){
            msg.put("code","200");
        }
        return JSONObject.toJSONString(msg);
    }


}
