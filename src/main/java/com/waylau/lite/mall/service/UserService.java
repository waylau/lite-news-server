package com.waylau.lite.mall.service;

import com.waylau.lite.mall.domain.User;

public interface UserService {

	User getUser(Long userId);

	void updateUser(User user);
}
