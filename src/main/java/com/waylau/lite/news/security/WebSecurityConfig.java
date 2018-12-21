/**
 * Welcome to https://waylau.com
 */
package com.waylau.lite.news.security;

import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Spring Security Configuration.
 * 
 * @since 1.0.0 2018年12月12日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@EnableWebSecurity // 启用Spring Security功能
@Order(1)  // 覆盖Lite框架里面的配置
public class WebSecurityConfig 
	extends WebSecurityConfigurerAdapter {

	/**
	 * 自定义配置
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception { 

		// 启用form表单认证
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
	}

}