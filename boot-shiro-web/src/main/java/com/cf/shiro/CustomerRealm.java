package com.cf.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cf.model.User;
import com.cf.service.UserService;

public class CustomerRealm extends AuthorizingRealm {
	private static final Logger log = LoggerFactory.getLogger(CustomerRealm.class);
	
	@Autowired
	private UserService userService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		log.info("<------------------------- 获取授权信息--------------------------------------------->");
		String userName = (String) principals.getPrimaryPrincipal();
		User user = userService.queryUserByUserName(userName);
		if (user != null) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			info.addRoles(userService.getUerRoleListByName(userName));
			info.addStringPermissions(userService.getUerPermissionsListByName(userName));
			return info;
		}

		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		log.info("<------------------------------获取身份认证信息------------------------------------->");
		log.info("<------------------------------"+userService+"------------------------------------->");
		String userName = (String) token.getPrincipal();
		User user = userService.queryUserByUserName(userName);
		if (user != null) {
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getEmail(), user.getPassword(), getName());
			return info;
		}
		return null;
	}

}
