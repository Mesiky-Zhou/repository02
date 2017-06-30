package com.framework.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.framework.bean.Dept;
import com.framework.bean.DeptWhere;
import com.framework.core.Msg;
import com.framework.service.DeptService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sysmgr/depts")
public class DeptController {
	@Autowired
	DeptService deptService;

	
	
	@RequestMapping("/forInitSelect")
	@ResponseBody
	public Msg listWithNoPage(
			Map<String,Object> map){
		List<Dept> list = this.deptService.queryForList(new DeptWhere());
		
		return  Msg.success().add("list", list);
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	@ResponseBody
	public Msg list(@RequestParam(value="pageNo",defaultValue="1") int pageNo,
			Map<String,Object> map){
		
		PageInfo<Dept> pageInfo = this.deptService.queryForPage(new DeptWhere(), pageNo,6);
		
		return  Msg.success().add("pageInfo", pageInfo);
	}
}
