package com.jerry.frame.demo.dubbo;

import org.springframework.stereotype.Service;

import com.jerry.frame.demo.dto.UserInfoDTO;
import com.jerry.frame.exception.BusinessException;

public interface IUserServiceRSV {

	public void addUser(UserInfoDTO userInfoDTO) throws BusinessException;
	
	public UserInfoDTO getUserInfoByUserName(UserInfoDTO userInfoDTO)throws BusinessException;
	
}
