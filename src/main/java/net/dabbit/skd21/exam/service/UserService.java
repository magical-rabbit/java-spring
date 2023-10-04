package net.dabbit.skd21.exam.service;

import net.dabbit.skd21.exam.entity.JsGridData;
import net.dabbit.skd21.exam.entity.User;

public interface UserService {

    String login(User user);
    String list(JsGridData jsdata);

    String del(Integer id);

    String add(User user);

    String update(User user);
}
