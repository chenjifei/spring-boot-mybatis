package com.cf.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//在ShiroConfiguration中要使用@Bean在ApplicationContext注入MyRealm，不能直接new对象。 
//道理和Controller中调用Service一样，都要是SpringBean，不能自己new。
@Configuration
public class CustomerRealmConfig {
	private static final Logger log = LoggerFactory.getLogger(CustomerRealmConfig.class);

	@Bean(name = "myRealm")
	public CustomerRealm customerRealm() {
		CustomerRealm myRealm = new CustomerRealm();
		return myRealm;
	}

	@Bean(name = "securityManager")
	public DefaultSecurityManager getDefaultSecurityManager(CustomerRealm myRealm) {
		log.info("<---------------getDefaultSecurityManager---------------------->");
		DefaultSecurityManager securityManager = new DefaultSecurityManager();
		securityManager.setRealm(myRealm);
		SecurityUtils.setSecurityManager(securityManager);

		return securityManager;
	}

}
