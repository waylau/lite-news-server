/**
 * Welcome to https://waylau.com
 */
package com.waylau.lite.mall.mapper;

import com.waylau.lite.mall.domain.User;

/**
 * User Mapper.
 * 
 * @since 1.0.0 2018年8月19日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public interface UserMapper {

	User getUser(Long userId);

	void updateUser(User user);

}
