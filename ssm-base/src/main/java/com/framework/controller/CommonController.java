package com.framework.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.framework.core.CacheData;
import com.framework.core.Msg;
import com.framework.core.PageConfig;

@Controller
@RequestMapping("/sysmgr/common")
public class CommonController {
	@Autowired
	CacheData cacheData;

	@RequestMapping("/getPageConfig/{code}")
	@ResponseBody
	public Msg getListConfig(@PathVariable("code") String code){
		return  Msg.success().add("pageConfig", cacheData.getPageConfig(code));
	}
	
	
	@RequestMapping("/goIndex/{code}")
	public String goIndex(@PathVariable("code") String code, Map<String,Object> map){
		PageConfig pageConfig = cacheData.getPageConfig(code);
		
		map.put("pageConfig", pageConfig);
		return  "/common/indexPageTemplate";
	}
	
}
