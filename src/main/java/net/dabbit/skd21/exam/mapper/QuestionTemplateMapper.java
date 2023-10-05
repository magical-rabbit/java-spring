package net.dabbit.skd21.exam.mapper;

import com.test.emis.entity.QuestionTemplate;
import net.dabbit.skd21.exam.entity.JsGridData;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionTemplateMapper {
    //添加题目模板
    int add(QuestionTemplate questionTemplate);
    //获得列表
    QuestionTemplate list(JsGridData jsdata);

    //修改模板
    int update(QuestionTemplate questionTemplate);

    //删除模板
    int del(Integer id);
}
