package com.jerry.frame.util;

import org.junit.Test;

import com.jerry.frame.demo.dto.UserInfoDTO;

public class TestUtils {

	@Test
	 public void testValidate(){
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		userInfoDTO.setAge(1l);
		ExceptionValidateUtil.validateNullVal(UserInfoDTO.class, userInfoDTO, new String[]{"name","age"});
		
	}
	
}
