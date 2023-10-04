package com.test.emis.mapper;

import com.test.emis.entity.RoleMenu;

public interface RoleMenuMapper {
    int insert(RoleMenu record);

    int insertSelective(RoleMenu record);
}