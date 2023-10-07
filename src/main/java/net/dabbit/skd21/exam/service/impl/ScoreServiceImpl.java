package net.dabbit.skd21.exam.service.impl;


import com.alibaba.fastjson.JSONObject;
import net.dabbit.skd21.exam.autogen.entity.Score;
import net.dabbit.skd21.exam.autogen.mapper.ScoreMapper;
import net.dabbit.skd21.exam.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
}
