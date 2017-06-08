package com.chinasoft.spring.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasoft.spring.bean.User;
import com.chinasoft.spring.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;
	
	
	
	@RequestMapping("/doLogin")
	@ResponseBody
	public User doLogin(User user){
		User login=userService.queryUser(user);
		System.err.println(login.toString());
		return login;
	}
}
