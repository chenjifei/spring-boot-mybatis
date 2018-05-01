package com.cf.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cf.dao.UserDao;
import com.cf.model.Permission;
import com.cf.model.Role;
import com.cf.model.User;
import com.cf.service.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> findAllUser() {
		return userDao.queryAllUser();
	}

	@Override
	public User queryUserByUserName(String userName) {
		return userDao.findUserByName(userName);
	}

	@Override
	public Collection<String> getUerPermissionsListByName(String userName) {
		Set<String> set = new HashSet<String>(10);
		List<Role> rList = userDao.queryRoleList(userName);
		for (Role role : rList) {
			set.add(role.getRoleName());
		}
		return set;
	}

	@Override
	public Collection<String> getUerRoleListByName(String userName) {
		Set<String> set = new HashSet<String>(10);
		List<Permission> rList = userDao.queryPermissionsList(userName);
		for (Permission permission : rList) {
			set.add(permission.getPermissionName());
		}
		return set;
	}

}
