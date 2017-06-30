package com.framework.controller;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.framework.bean.User;
import com.framework.bean.UserWhere;
import com.framework.core.Msg;
import com.framework.core.web.LoginInfo;
import com.framework.service.UserService;

@Controller
@RequestMapping("/sysmgr")
public class LoginController{
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/login")
	@ResponseBody
	public Msg login(@RequestParam("userName") String userName,@RequestParam("password") String password,
			HttpSession session){
		UserWhere where = new UserWhere();
		where.createCriteria().andUserNameEqualTo(userName).andPasswordEqualTo(password);
		List<User> list = this.userService.queryForList(where);
		if(list!=null && list.size()==1){
			User user = list.get(0);
			
			LoginInfo li = new LoginInfo("user", user);
			session.setAttribute(LoginInfo.SESSION_KEY, li);
			
			return  Msg.success("登陆认证成功！");
		}else{
			return  Msg.fail("登陆认证失败！");
		}
	}
	
	@RequestMapping("/logout")
	@ResponseBody
	public Msg logout(HttpSession session){
		session.invalidate();
		return  Msg.success();
	}
	
	@RequestMapping("/main")
	public String loginSuccess(){
		return "/sysmgr/main";
	}
	
	
}
