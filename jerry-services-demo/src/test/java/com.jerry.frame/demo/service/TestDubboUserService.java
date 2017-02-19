package com.jerry.frame.demo.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jerry.frame.BaseJunit4Test;
import com.jerry.frame.demo.dto.UserInfoDTO;
import com.jerry.frame.demo.dubbo.IUserServiceRSV;
@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试  
@ContextConfiguration   
(locations={"classpath*:**/spring-dubbo-client-test.xml"}) //加载配置文件  
public class TestDubboUserService extends BaseJunit4Test 
{
	@Resource
	private IUserServiceRSV userServiceRSV;

	@Test
	public void testDataAccess() {
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		userInfoDTO.setId(10l);
		userInfoDTO.setName("jerry1");
		userInfoDTO.setAge(11l);
		userInfoDTO.setPassword("2222");
		userServiceRSV.addUser(userInfoDTO);
	}

}
