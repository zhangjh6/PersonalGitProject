package com.jerry.web.manage.authenticate.model;

import org.springframework.security.core.GrantedAuthority;

public class CustomAuthority implements GrantedAuthority {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3398920399694163411L;
	private String role;
    
	public CustomAuthority(String role) {
		this.role = role;
	}

	public String getAuthority() {
		// TODO Auto-generated method stub
		return role;
	}

}
