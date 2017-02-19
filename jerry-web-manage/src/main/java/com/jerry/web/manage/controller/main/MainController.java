package com.jerry.web.manage.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping({"/main"})
public class MainController {
@RequestMapping({"/homePage"})
	public String homePage(){			
		return "/main/homePage";
	}
	
}
