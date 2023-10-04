package net.dabbit.skd21.exam.service;

import net.dabbit.skd21.exam.entity.JsGridData;
import org.springframework.stereotype.Service;

@Service
public interface MenuService {
    String list(JsGridData jsGridData);
    String add(JsGridData jsGridData);
}
