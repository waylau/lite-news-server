/**
 * Welcome to https://waylau.com
 */
package com.waylau.lite.news.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.transaction.annotation.Transactional;

import com.waylau.lite.news.AppConfig;
import com.waylau.lite.news.domain.User;

/**
 * UserMapper Tests.
 * 
 * @since 1.0.0 2019年1月30日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@SpringJUnitWebConfig(classes = AppConfig.class)
@Transactional
class UserMapperTests {

	static final Logger logger = LoggerFactory.getLogger(UserMapperTests.class);

	@Autowired
	private UserMapper userMapper;

	@Test
	void testCreatetUser() {
		User user = new User();
		user.setUsername("waylau");
		user.setPassword("123456");
		user.setEmail("waylau521@gmail.com");
		userMapper.createUser(user);
		logger.info(user.toString());
	}

	@Test
	void testDeleteUser() {
		userMapper.deleteUser(1L);

		User userNew = userMapper.getUser(1L);
		assertNull(userNew);
	}

	@Test
	void testUpdateUser() {
		User user = userMapper.getUser(1L);
		user.setPassword("12345678");
		user.setEmail("waylau521@gmail.com");
		userMapper.updateUser(user);

		User userNew = userMapper.getUser(1L);
		assertEquals(user.getPassword(), userNew.getPassword());
	}

	@Test
	void testGetUser() {
		User user = userMapper.getUser(1L);
		assertEquals("waylau", user.getUsername());
	}

	@Test
	void testGetUserByUsername() {
		User user = userMapper.getUserByUsername("waylau");
		assertEquals("waylau", user.getUsername());
	}
}
