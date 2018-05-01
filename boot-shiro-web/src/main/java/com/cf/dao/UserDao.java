package com.cf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cf.model.Permission;
import com.cf.model.Role;
import com.cf.model.User;

@Mapper
public interface UserDao {
	List<User> queryAllUser();

	User findUserByName(@Param("email") String email);

	List<Role> queryRoleList(@Param("email") String email);

	List<Permission> queryPermissionsList(@Param("email") String email);
}
