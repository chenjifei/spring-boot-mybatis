package com.cf.model;

import java.io.Serializable;

/**
 * 角色
 * @author Administrator
 *
 */
public class Role implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5181906161924313443L;
	private Integer id;
	private String roleName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + "]";
	}

}
