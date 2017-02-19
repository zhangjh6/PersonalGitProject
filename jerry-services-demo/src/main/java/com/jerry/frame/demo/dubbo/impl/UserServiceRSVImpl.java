package com.jerry.frame.demo.dubbo.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jerry.frame.demo.dto.UserInfoDTO;
import com.jerry.frame.demo.dubbo.IUserServiceRSV;
import com.jerry.frame.demo.service.IUserServiceSV;
import com.jerry.frame.exception.BusinessException;
@Service
public class UserServiceRSVImpl implements IUserServiceRSV{
@Resource
private IUserServiceSV userServiceSV;

	public void addUser(UserInfoDTO userInfoDTO) throws BusinessException {
		// TODO Auto-generated method stub
		try{
		userServiceSV.addUser(userInfoDTO);
		}catch(BusinessException be){
			throw be;
			
		}catch(Exception e){
			
			throw new BusinessException("系统错误！",e);
		}
	}

	public UserInfoDTO getUserInfoByUserName(UserInfoDTO userInfoDTO) throws BusinessException {
		// TODO Auto-generated method stub
		try{
			return userServiceSV.getUserInfoByUserName(userInfoDTO);
			}catch(BusinessException be){
				throw be;
				
			}catch(Exception e){
				
				throw new BusinessException("系统错误！",e);
			}
	}

}
