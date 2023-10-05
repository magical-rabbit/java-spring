package net.dabbit.skd21.exam.mapper;

import net.dabbit.skd21.exam.entity.JsGridData;
import net.dabbit.skd21.exam.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    List<Menu> list(JsGridData jsGridData);
    Long count(JsGridData jsGridData);
    Integer add(Menu menu);
}
