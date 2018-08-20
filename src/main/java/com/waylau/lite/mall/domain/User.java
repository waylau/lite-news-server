/**
 * Welcome to https://waylau.com
 */
package com.waylau.lite.mall.domain;

/**
 * User.
 * 
 * @since 1.0.0 2018年8月19日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public class User {

	private Long userId;
	private String username;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + "]";
	}
	
}
