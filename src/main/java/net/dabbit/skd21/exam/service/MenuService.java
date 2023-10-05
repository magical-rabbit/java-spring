package net.dabbit.skd21.exam.service;

import net.dabbit.skd21.exam.entity.JsGridData;
import net.dabbit.skd21.exam.entity.Menu;
import org.springframework.stereotype.Service;

@Service
public interface MenuService {
    String list(JsGridData jsGridData);
    String add(Menu menu);
    String del(Integer id);
    String modify(Menu menu);
}
