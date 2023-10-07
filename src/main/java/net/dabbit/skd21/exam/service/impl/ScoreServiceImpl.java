package net.dabbit.skd21.exam.service.impl;


import com.alibaba.fastjson.JSONObject;
import net.dabbit.skd21.exam.autogen.entity.Score;
import net.dabbit.skd21.exam.autogen.mapper.ScoreMapper;
import net.dabbit.skd21.exam.entity.JsGridData;
import net.dabbit.skd21.exam.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    ScoreMapper scoreMapper;

    @Override
    public String query(int user_id, int subject_id) {
        Score sc = scoreMapper.queryByUserIdAndSubjectId(user_id,subject_id);
        if(sc==null){
            Map<String,String> msg = new HashMap<String,String>();
            msg.put("msg","2333");
            msg.put("code","401");
            msg.put("error","没有找到相关的分数");
            return JSONObject.toJSONString(msg);
        }
        return JSONObject.toJSONString(sc);
    }

    @Override
    public String add(Score score) {
        Map<String,String> msg = new HashMap<String,String>();
        msg.put("msg","2333");
        int add_ = scoreMapper.insertSelective(score);
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

        Long cnt = scoreMapper.count(jsdata);
        List<Score> list = scoreMapper.list(jsdata);
        //设置数据，设置列表数量
        jsdata.setData(list);
        jsdata.setItemsCount(cnt);
        //返回数据
        return JSONObject.toJSONString(jsdata);
    }

    @Override
    public String update(Score score) {
        Map<String,String> msg = new HashMap<String,String>();
        msg.put("msg","2333");
        msg.put("code", "200");
        msg.put("info", "想改分数？他真的改了吗？如改！");
        return JSONObject.toJSONString(msg);
    }

    @Override
    public String del(Integer id) {
        Map<String,String> msg = new HashMap<String,String>();
        msg.put("msg","2333");
        int del_ = scoreMapper.deleteByPrimaryKey(id);
        if(del_>0){
            msg.put("code","200");
        }else{
            msg.put("code","401");
            msg.put("info", "删除失败,修改条数小于1");
        }
        return JSONObject.toJSONString(msg);
    }
}
