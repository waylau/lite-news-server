/**
 * Welcome to https://waylau.com
 */
package com.waylau.lite.news.config;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * BCryptPasswordEncoder Tests.
 * 
 * @since 1.0.0 2019年1月31日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class BCryptPasswordEncoderTests {

	@Test
	void testEncode() {
		String rawPassword = "123456";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		// 加密
		String encodedPassword = passwordEncoder.encode(rawPassword);
		System.out.println("明文：" + rawPassword + " -> 密文：" + encodedPassword);
	}
	
	@Test
	void testMatches() {
		String rawPassword = "123456";
		String encodedPassword = "$2a$10$qZLF2y/a1yhfFZ.Lwhq9f.sOADw6QlBRRGL4XLodTHJJupkAEBB8i";

		// 判断是否匹配
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		boolean isMatch = passwordEncoder.matches(rawPassword, encodedPassword);
		
		assertTrue(isMatch);
	}

}
