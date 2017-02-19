package com.jerry.web.manage.authenticate;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jerry.frame.demo.dto.UserInfoDTO;
import com.jerry.frame.demo.dubbo.IUserServiceRSV;
import com.jerry.web.manage.authenticate.model.UserDetailWrapper;

public class UserDetailServiceImpl implements UserDetailsService {
	
	public IUserServiceRSV getUserServiceRSV() {
		return userServiceRSV;
	}

	public void setUserServiceRSV(IUserServiceRSV userServiceRSV) {
		this.userServiceRSV = userServiceRSV;
	}

	private IUserServiceRSV userServiceRSV;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserInfoDTO userInfoDTO  = new UserInfoDTO();
		userInfoDTO.setName(username);
		UserInfoDTO infoDTO = userServiceRSV.getUserInfoByUserName(userInfoDTO);
		UserDetailWrapper userDetails = new UserDetailWrapper(infoDTO);
		return userDetails;
	}

}
