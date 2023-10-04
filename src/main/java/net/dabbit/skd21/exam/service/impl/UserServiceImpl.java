package net.dabbit.skd21.exam.service.impl;

import com.alibaba.fastjson.JSONObject;
import net.dabbit.skd21.exam.entity.JsGridData;
import net.dabbit.skd21.exam.entity.User;
import net.dabbit.skd21.exam.mapper.UserMapper;
import net.dabbit.skd21.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
*
* 在springboot项目启动的时候，有service注解的类会直接创建一个对象
* */

//接口實現類

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public String login(User user) {
        //有数据就成功，没数据就失败，对应的属性，不是接口名
        Map<String,String> msg = new HashMap<String,String>();

        User u = userMapper.login(user);


        msg.put("code","999");

        if(u!=null){
            msg.put("code","200");
        }
        return JSONObject.toJSONString(msg);
    }

    /*
    *
    * {
    * "data": //数据集合
    * “itemCount”: //num
    * }
    * */

    @Override
    public String list(JsGridData jsdata) {

        //1.查询数据集合

        List<User> users = userMapper.list(jsdata);

        Long cnt = userMapper.count(jsdata);
        //2. 根据当前条件查询条数

        jsdata.setData(users);
        jsdata.setItemsCount(cnt);
        return JSONObject.toJSONString(jsdata);
        ///return "";
    }

    @Override
    public String del(Integer id){
        /*
        * mybatis在增删改查的操作时候，会返回一个int
        * 回复的内容是数据库记录的改变的条数
        * */
        int i = userMapper.del(id);
        Map<String,String> msg = new HashMap<>();
        msg.put("msg","999");
        if(i>0){
            msg.put("code","200");
        }
        return JSONObject.toJSONString(msg);
//        return i==0?
    }

    @Override
    public String add(User user){
        /*
         * mybatis在增删改查的操作时候，会返回一个int
         * 回复的内容是数据库记录的改变的条数
         * */
        int i = userMapper.add(user);
        Map<String,String> msg = new HashMap<>();
        msg.put("msg","999");
        if(i>0){
            msg.put("code","200");
        }
        return JSONObject.toJSONString(msg);
//        return i==0?
    }

    @Override
    public String update(User user){
        /*
         * mybatis在增删改查的操作时候，会返回一个int
         * 回复的内容是数据库记录的改变的条数
         * */
        int i = userMapper.update(user);
        Map<String,String> msg = new HashMap<>();
        msg.put("msg","999");
        if(i>0){
            msg.put("code","200");
        }
        return JSONObject.toJSONString(msg);
    }
}
