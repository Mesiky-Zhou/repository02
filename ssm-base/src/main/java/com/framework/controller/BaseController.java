package com.framework.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.framework.core.CacheData;
import com.framework.core.Msg;
import com.framework.core.PageConfig;
import com.framework.core.StaticData;
import com.framework.service.BaseService;
import com.framework.utils.GenericsUtils;
import com.github.pagehelper.PageInfo;


public abstract class BaseController<T,W> {
	
	//========================��׼START===========================================
	@Autowired
	CacheData cacheData;
	
	public abstract BaseService<T,W> getService();


	//�б�����
	@SuppressWarnings("unchecked")
	@RequestMapping(value="", method=RequestMethod.GET)
	@ResponseBody
	public Msg list(@RequestParam(value="pageNo",defaultValue="1") int pageNo,
			Map<String,Object> map){
		PageConfig pageConfig = cacheData.getPageConfig(StaticData.userIndexKey);
		
		PageInfo<T> pageInfo = this.getService().queryForPage(
				(W)GenericsUtils.getSuperClassGenricInstance(this.getClass(), 1), pageNo, pageConfig.getPageSize());
		
		return  Msg.success().add("pageInfo", pageInfo);
	}
	
	//��������
	@RequestMapping(value="", method=RequestMethod.POST)
	@ResponseBody
	public Msg add(@Valid T record,BindingResult result){
		if(result.hasErrors()){
			List<FieldError> fes = result.getFieldErrors();
			Map<String,String> map = new HashMap<>();
			for(FieldError fe : fes){
				map.put(fe.getField(), fe.getDefaultMessage());
			}
			
			return  Msg.fail().add("errorMessages", map);
		}else{
			this.getService().save(record);
			
			return  Msg.success();
		}
	}
	
	//ɾ������
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	@ResponseBody
	public Msg delete(@PathVariable("id") String ids){
		if(ids!=null && ids.indexOf("-")>0){
			List<Integer> idList = new ArrayList<>();
			String idArr[] = ids.split("-");
			for(String id : idArr){
				idList.add(Integer.parseInt(id));
			}
			
			this.getService().deleteByIds(idList);
			
		}else{
			Integer id = Integer.parseInt(ids);
			
			this.getService().delete(id);
		}
		
		return Msg.success();
	}
	
	//��������
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	@ResponseBody
	public Msg update(T record){
		this.getService().update(record);
		
		return Msg.success();
	}
	
	//�鿴����
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Msg get(@PathVariable("id") Integer id){
		T bean = this.getService().get(id);
		
		return Msg.success().add("bean", bean);
	}
	
	//========================��׼END===========================================
	
}
