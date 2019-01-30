/**
 * Welcome to https://waylau.com
 */
package com.waylau.lite.news.mapper;

import com.waylau.lite.news.domain.User;

/**
 * User Mapper.
 * 
 * @since 1.0.0 2019年1月19日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public interface UserMapper {

	void createUser(User user);

	void deleteUser(Long userId);
	
	void updateUser(User user);

	User getUser(Long userId);
	
	User getUserByUsername(String username);

}
