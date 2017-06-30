package com.framework.controller;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.framework.bean.User;
import com.framework.bean.UserWhere;
import com.framework.core.PageConfig;
import com.framework.core.StaticData;
import com.framework.service.BaseService;
import com.framework.service.UserService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sysmgr/users")
public class UserController extends BaseController<User,UserWhere>{
	
	//========================±ê×¼START===========================================
	@Autowired
	UserService userService;

	@Override
	public BaseService<User, UserWhere> getService() {
		return this.userService;
	}
	
	
	@RequestMapping("/web/list1")
	public String list1(@RequestParam(value="pageNo",defaultValue="1") int pageNo,
			Map<String,Object> map){
		PageConfig pageConfig = cacheData.getPageConfig(StaticData.userIndexKey);
		
		PageInfo<User> pageInfo = this.userService.queryForPage(new UserWhere(), pageNo, pageConfig.getPageSize());
		
		map.put("pageInfo", pageInfo);
		return  "/user/list1";
	}
}
