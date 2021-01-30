package com.sxt.service;

import com.sxt.domain.User;

public interface UserService {

	/**
	 * 根据用户名查询用户对象
	 */
	public User queryUserByUserName(String username);
}
