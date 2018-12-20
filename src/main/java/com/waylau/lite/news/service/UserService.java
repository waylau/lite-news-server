package com.waylau.lite.news.service;

import com.waylau.lite.news.domain.User;

public interface UserService {

	User getUser(Long userId);

	void updateUser(User user);
}
