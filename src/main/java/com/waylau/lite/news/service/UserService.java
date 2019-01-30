package com.waylau.lite.news.service;

import com.waylau.lite.news.domain.User;

/**
 * User Service.
 * 
 * @since 1.0.0 2019年1月30日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public interface UserService {

	void createUser(User user);

	void deleteUser(Long userId);
	
	void updateUser(User user);

	User getUser(Long userId);
}
