package net.dabbit.skd21.exam.mapper;

import net.dabbit.skd21.exam.entity.QuestionTemplate;
import net.dabbit.skd21.exam.entity.JsGridData;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionTemplateMapper {
    //添加题目模板
    int add(QuestionTemplate questionTemplate);
    //获得列表
    List<QuestionTemplate> list(JsGridData jsdata);

    //修改模板
    int update(QuestionTemplate questionTemplate);

    //删除模板
    int del(Integer id);

    //计数

    Long count(JsGridData jsdata);
}
