package net.dabbit.skd21.exam.service;

import org.springframework.stereotype.Service;


import net.dabbit.skd21.exam.autogen.entity.Role;
import net.dabbit.skd21.exam.entity.JsGridData;


@Service
public class RoleService {
    String add(Role role);
    String list(JsGridData jsdata);
    String update(Role role);
    String del(Integer id);
}
