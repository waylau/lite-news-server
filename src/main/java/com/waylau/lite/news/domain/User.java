/**
 * Welcome to https://waylau.com
 */
package com.waylau.lite.news.domain;

/**
 * User.
 * 
 * @since 1.0.0 2019年1月30日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class User {

	private Long userId;
	private String username;
	private String password;
	private String email;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
