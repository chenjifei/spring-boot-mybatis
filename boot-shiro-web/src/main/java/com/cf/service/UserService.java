package com.cf.service;

import java.util.Collection;
import java.util.List;

import com.cf.model.User;

public interface UserService {
	List<User> findAllUser();

	User queryUserByUserName(String userName);

	Collection<String> getUerPermissionsListByName(String userName);

	Collection<String> getUerRoleListByName(String userName);
}
