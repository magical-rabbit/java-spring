package net.dabbit.skd21.exam.controller;

import com.alibaba.fastjson.JSONObject;
import net.dabbit.skd21.exam.autogen.entity.Score;
import net.dabbit.skd21.exam.autogen.mapper.ScoreMapper;
import net.dabbit.skd21.exam.entity.User;
import net.dabbit.skd21.exam.mapper.UserMapper;
import net.dabbit.skd21.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    ScoreMapper scoreMapper;

    @RequestMapping(value = "/givemyscore",produces = "application/json; charset=utf-8")
    @ResponseBody
    public  String login(User user){
        Map<String,String> msg = new HashMap<String,String>();
        User u = userMapper.login(user);
        msg.put("code","999");

        if(u!=null){

            List<Score> ls = scoreMapper.queryByUserId(u.getId());
            //给他分数！
            if(ls == null){
                msg.put("code","401");
                msg.put("info","没有找到你的分数");
                return JSONObject.toJSONString(msg);
            }
            msg.put("code","200");
            return JSONObject.toJSONString(ls);
        }
        msg.put("code","401");
        msg.put("info","错误的用户名或者密码");
        return JSONObject.toJSONString(msg);
    }
}
