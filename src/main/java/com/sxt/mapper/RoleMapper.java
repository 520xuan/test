package com.sxt.mapper;

import java.util.List;

import com.sxt.domain.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    /**
     * 查询用户ID查询角色
     * @param userId
     * @return
     */
	List<Role> queryRolesByUserId(Integer userId);
}