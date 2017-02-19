package com.jerry.frame.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jerry.frame.demo.dao.common.gds.MallUserMapper;
import com.jerry.frame.demo.dto.UserInfoDTO;
import com.jerry.frame.demo.model.common.gds.MallUser;
import com.jerry.frame.demo.model.common.gds.MallUserExample;
import com.jerry.frame.demo.service.IUserServiceSV;
import com.jerry.frame.util.ExceptionValidateUtil;
import com.jerry.frame.util.ObjectCopyUtil;
@Service
public class UserServiceSVImpl implements IUserServiceSV {
	@Resource
	private MallUserMapper mallUserMapper;

	public void addUser(UserInfoDTO userInfoDTO) {
		// TODO Auto-generated method stub
		MallUser record = new MallUser();
		ObjectCopyUtil.copyObjValue(userInfoDTO, record, null, false);
		mallUserMapper.insert(record);
	}

	public UserInfoDTO getUserInfoByUserName(UserInfoDTO userInfoDTO) {
		// TODO Auto-generated method stub
		ExceptionValidateUtil.validateNullVal(UserInfoDTO.class, userInfoDTO, "name");
		MallUserExample example = new MallUserExample();
		MallUserExample.Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(userInfoDTO.getName());
		List<MallUser> mallUsers =  mallUserMapper.selectByExample(example);
		if(mallUsers.size() > 0){
			UserInfoDTO infoDTO = new UserInfoDTO();	
			ObjectCopyUtil.copyObjValue(mallUsers.get(0), infoDTO, null, false);
			return infoDTO;
		}
		return null;
	}

}
