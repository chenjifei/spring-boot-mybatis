package com.cf.model;

import java.io.Serializable;
/**
 * 用户
 * @author Administrator
 *
 */
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6589182192727327723L;
	private Integer id;
	private String name;
	private String password;
	private String email;
	private Integer age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", age=" + age
				+ "]";
	}

}
