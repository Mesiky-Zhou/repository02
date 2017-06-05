package com.framework.core;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.framework.bean.IndexConfig;
import com.framework.service.IndexConfigService;

@Component
public class CacheData {
	private static Map<String,PageConfig> pageConfigs = new HashMap<>();
	
	@Autowired
	IndexConfigService indexConfigService;
	
	public PageConfig getPageConfig(String code){
		PageConfig obj = pageConfigs.get(code);
		if(obj == null){
			IndexConfig indexConfig = indexConfigService.getByCode(code);
			obj = new PageConfig(indexConfig);
			addPageConfig(code, obj);
		}
		return obj;
	}
	
	public  void addPageConfig(String code, PageConfig value){
		pageConfigs.put(code, value);
	}
	

}
