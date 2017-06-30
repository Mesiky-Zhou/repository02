package com.framework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.bean.TestBean;
import com.framework.bean.TestBeanWhere;
import com.framework.dao.TestBeanMapper;

@Service
public class TestBeanService extends BaseService<TestBean,TestBeanWhere>{
	@Autowired
	TestBeanMapper testBeanMapper;

	@Override
	public Object getMapper() {
		return this.testBeanMapper;
	}
	
}
