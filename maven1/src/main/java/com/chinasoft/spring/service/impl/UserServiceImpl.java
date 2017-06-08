package com.chinasoft.spring.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinasoft.spring.bean.User;
import com.chinasoft.spring.dao.IUserDao;
import com.chinasoft.spring.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService{
	@Resource
	private IUserDao userMapper;
	
	@Override
	public User queryUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.queryUser(user);
	}

}
