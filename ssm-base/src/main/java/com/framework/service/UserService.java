package com.framework.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.bean.User;
import com.framework.bean.UserWhere;
import com.framework.dao.UserMapper;

@Service
public class UserService extends BaseService<User,UserWhere>{

	@Autowired
	UserMapper userMapper;
	
	@Override
	public Object getMapper() {
		return this.userMapper;
	}
	
}
