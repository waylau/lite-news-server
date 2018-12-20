/**
 * Welcome to https://waylau.com
 */
package com.waylau.lite.mall.domain;

import java.util.Date;

/**
 * User.
 * 
 * @since 1.0.0 2018年8月19日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public class User {

	private Long userId;
	private String username;
	private Date birthday;
	private Date updatedTime;
	
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", birthday=" + birthday + ", updatedTime="
				+ updatedTime + "]";
	}
	
}
