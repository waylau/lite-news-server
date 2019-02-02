/**
 * Welcome to https://waylau.com
 */
package com.waylau.lite.news.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Spring Security Configuration.
 * 
 * @since 1.0.0 2019年1月31日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@EnableWebSecurity // 启用Spring Security功能
@Order(1)  // 覆盖Lite框架里面的配置
public class WebSecurityConfig 
	extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean  
	public PasswordEncoder passwordEncoder() {  
	    return new BCryptPasswordEncoder();   // 使用 BCrypt 加密
	}  

	@Bean  
	public AuthenticationProvider authenticationProvider() {  
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder); // 设置密码加密方式
	    return authenticationProvider;  
	} 
	
	/**
     * 认证信息管理
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetailsService);
    	auth.authenticationProvider(authenticationProvider());
    }

	/**
	 * 自定义配置
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception { 
		http.authorizeRequests().antMatchers("/css/**", "/js/**", "/fonts/**", "/index").permitAll() // 都可以访问
		.antMatchers("/admins/**").hasRole("ADMIN") // 需要相应的角色才能访问
		//.and()
		//.formLogin()   //基于 Form 表单登录验证
		.and()
		.httpBasic(); // HTTP基本认证
		http.csrf().disable(); // 禁用CSRF
	}

}