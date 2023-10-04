package net.dabbit.skd21.exam.service.impl;


import com.alibaba.fastjson.JSONObject;
import net.dabbit.skd21.exam.entity.Classes;
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
}
