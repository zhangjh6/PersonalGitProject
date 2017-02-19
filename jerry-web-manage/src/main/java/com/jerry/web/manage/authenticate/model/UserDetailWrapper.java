package com.jerry.web.manage.authenticate.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jerry.frame.demo.dto.UserInfoDTO;

public class UserDetailWrapper implements UserDetails {
	private UserInfoDTO infoDTO;

	public UserInfoDTO getInfoDTO() {
		return infoDTO;
	}

	public UserDetailWrapper(UserInfoDTO infoDTO) {

		this.infoDTO = infoDTO;

	}

	public void setInfoDTO(UserInfoDTO infoDTO) {
		this.infoDTO = infoDTO;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return infoDTO.getPassword();
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return infoDTO.getName();
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	// 必须返回，否则无法校验
	public Collection<GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> authories = new ArrayList<GrantedAuthority>();
		GrantedAuthority grantedAuthority =null;
	    if(this.getUsername().equals("jerry")){
			 grantedAuthority = new CustomAuthority("jerry");
	    	
	    }else{
			 grantedAuthority = new CustomAuthority("jerry1");

	    }
	    authories.add(grantedAuthority);
		return authories;
	}

}
