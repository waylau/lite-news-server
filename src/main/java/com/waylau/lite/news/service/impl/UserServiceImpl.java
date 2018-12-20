/**
 * Welcome to https://waylau.com
 */
package com.waylau.lite.news.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waylau.lite.news.domain.User;
import com.waylau.lite.news.mapper.UserMapper;
import com.waylau.lite.news.service.UserService;

/**
 * User Service.
 * 
 * @since 1.0.0 2018年8月21日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User getUser(Long userId) {
		return userMapper.getUser(userId);
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

}
