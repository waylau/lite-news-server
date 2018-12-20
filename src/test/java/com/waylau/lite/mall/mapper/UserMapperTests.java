/**
 * Welcome to https://waylau.com
 */
package com.waylau.lite.mall.mapper;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import com.waylau.lite.mall.AppConfig;
import com.waylau.lite.mall.domain.User;

/**
 * UserMapper Tests.
 * 
 * @since 1.0.0 2018年8月19日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@SpringJUnitWebConfig(classes = AppConfig.class)
class UserMapperTests {
	
	static final Logger logger = LoggerFactory.getLogger(UserMapperTests.class);

	@Autowired
	private UserMapper userMapper;
	
	@Test
	void testGetUser() {
		User user = userMapper.getUser(1L);
		logger.info(user.toString());
	}
	
	@Test
	void testUpdateUser() {
		User user = userMapper.getUser(1L);
		user.setUsername("waylau");
		user.setBirthday(new Date());
		
		LocalDate localDate = LocalDate.now();   
		ZoneId zone = ZoneId.systemDefault();    
		Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();    
		java.util.Date date = Date.from(instant);
		
		user.setUpdatedTime( date);
		userMapper.updateUser(user);
		user = userMapper.getUser(1L);
		logger.info(user.toString());
	}
	
}
