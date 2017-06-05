package com.framework.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.framework.bean.User;
import com.framework.core.CacheData;
import com.framework.core.Msg;
import com.framework.core.PageConfig;
import com.framework.core.StaticData;
import com.framework.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sysmgr/users")
public class UserController {
	
	//========================标准START===========================================
	@Autowired
	CacheData cacheData;
	
	@Autowired
	UserService service;


	//列表请求
	@RequestMapping(value="", method=RequestMethod.GET)
	@ResponseBody
	public Msg list(@RequestParam(value="pageNo",defaultValue="1") int pageNo,
			Map<String,Object> map){
		PageConfig pageConfig = cacheData.getPageConfig(StaticData.userIndexKey);
		PageHelper.startPage(pageNo,pageConfig.getPageSize());
		List<User> list = this.service.getAll();
		PageInfo<User> pageInfo = new PageInfo<User>(list,5);
		
		return  Msg.success().add("pageInfo", pageInfo)
				.add("pageConfig", pageConfig);
	}
	
	//新增请求
	@RequestMapping(value="", method=RequestMethod.POST)
	@ResponseBody
	public Msg add(@Valid User user,BindingResult result){
		if(result.hasErrors()){
			List<FieldError> fes = result.getFieldErrors();
			Map<String,String> map = new HashMap<>();
			for(FieldError fe : fes){
				map.put(fe.getField(), fe.getDefaultMessage());
			}
			
			return  Msg.fail().add("errorMessages", map);
		}else{
			user.setCreateTime(new Date());
			this.service.save(user);
			
			return  Msg.success();
		}
	}
	
	//删除请求
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	@ResponseBody
	public Msg delete(@PathVariable("id") String ids){
		if(ids!=null && ids.indexOf("-")>0){
			List<Integer> idList = new ArrayList<>();
			String idArr[] = ids.split("-");
			for(String id : idArr){
				idList.add(Integer.parseInt(id));
			}
			
			this.service.deleteByBatch(idList);
			
		}else{
			Integer id = Integer.parseInt(ids);
			
			this.service.deleteByPrimaryKey(id);
		}
		
		return Msg.success();
	}
	
	//更新请求
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	@ResponseBody
	public Msg update(User user){
		this.service.updateByPrimaryKey(user);
		
		return Msg.success();
	}
	
	//查看请求
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Msg get(@PathVariable("id") Integer id){
		User bean = this.service.getByPrimaryKey(id);
		
		return Msg.success().add("bean", bean)
				.add("pageConfig", cacheData.getPageConfig(StaticData.userIndexKey));
	}
	
	//========================标准END===========================================
	
	@RequestMapping("/web/list1")
	public String list1(@RequestParam(value="pageNo",defaultValue="1") int pageNo,
			Map<String,Object> map){
		PageConfig pageConfig = cacheData.getPageConfig(StaticData.userIndexKey);
		PageHelper.startPage(pageNo, pageConfig.getPageSize());
		List<User> list = this.service.getAll();
		PageInfo<User> pageInfo = new PageInfo<User>(list,5);
		
		map.put("pageInfo", pageInfo);
		return  "/user/list1";
	}
}
