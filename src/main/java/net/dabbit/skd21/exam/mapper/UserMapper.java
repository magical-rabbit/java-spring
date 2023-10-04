package net.dabbit.skd21.exam.mapper;
import net.dabbit.skd21.exam.entity.JsGridData;
import net.dabbit.skd21.exam.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/*
* mybatis与springboot整合只需要在自己的接口文件上加上mapper注解
* 在项目启动之后，springboot项目会按照动态代理的方式来运行mapper接口的方法
* 封装所的技术，自定义注解，反射，动态代理
* */

@Mapper
public interface UserMapper {
    User login(User user) ;
    List<User> list(JsGridData jsdata);
    Long count(JsGridData jsdata);
    int del(Integer id);
    int add(User user);
    int update(User user);
}
