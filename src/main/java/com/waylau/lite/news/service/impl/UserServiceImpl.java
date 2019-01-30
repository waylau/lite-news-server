/**
 * Welcome to https://waylau.com
 */
package com.waylau.lite.news.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.waylau.lite.news.domain.User;
import com.waylau.lite.news.mapper.UserMapper;
import com.waylau.lite.news.service.UserService;

/**
 * User Service.
 * 
 * @since 1.0.0 2019年1月30日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	private final String ADMIN = "ROLE_ADMIN";

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

	@Override
	public void createUser(User user) {
		userMapper.createUser(user);
	}

	@Override
	public void deleteUser(Long userId) {
		userMapper.deleteUser(userId);
	}

	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		User user = userMapper.getUserByUsername(username);

		// 默认都是ADMIN角色
		List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(ADMIN));

		// 构建认证信息
		UserDetails userDetails = new org.springframework.security.core.userdetails.
				User(user.getUsername(),
				user.getPassword(), authorities);
		return userDetails;
	}

}
