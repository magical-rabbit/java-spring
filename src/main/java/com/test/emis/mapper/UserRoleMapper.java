package com.test.emis.mapper;

import com.test.emis.entity.UserRole;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);
}