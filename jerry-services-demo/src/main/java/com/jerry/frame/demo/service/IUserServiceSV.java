package com.jerry.frame.demo.service;

import org.springframework.stereotype.Service;

import com.jerry.frame.demo.dto.UserInfoDTO;

public interface IUserServiceSV {

	public void addUser(UserInfoDTO userInfoDTO);
	public UserInfoDTO getUserInfoByUserName(UserInfoDTO userInfoDTO) ;
}
