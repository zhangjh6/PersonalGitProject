package com.jerry.frame.demo.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jerry.frame.BaseJunit4Test;
import com.jerry.frame.demo.dto.UserInfoDTO;
@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试  
@ContextConfiguration   
(locations={"classpath*:**/spring-*.xml"}) //加载配置文件  
public class TestUserService extends BaseJunit4Test 
{
	@Resource
	private IUserServiceSV userService;

	@Test
	public void testDataAccess() {
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		userInfoDTO.setId(6l);
		userInfoDTO.setName("jerry22");
		userInfoDTO.setAge(11l);
		userInfoDTO.setPassword("2222");
		userService.addUser(userInfoDTO);
	}

}
