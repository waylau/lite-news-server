/**
 * Welcome to https://waylau.com
 */
package com.waylau.lite.mall.service;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import com.waylau.lite.mall.AppConfig;
import com.waylau.lite.mall.domain.User;

/**
 * 
 * @since 1.0.0 2018年8月21日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@SpringJUnitWebConfig(classes = AppConfig.class)
class UserServiceImplTests {
	
	static final Logger logger = LoggerFactory.getLogger(UserServiceImplTests.class);
	
	@Autowired
	UserService userService;
	
	@Test
	void testGetUser() {
		userService.getUser(1L);
	}
	
	@Test
	void testUpdateUser() {
		
		User user = userService.getUser(1L);
		user.setUsername("老卫");
		userService.updateUser(user);
		logger.info(user.toString());
	}
	
}
