package com.framework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.bean.Dept;
import com.framework.bean.DeptWhere;
import com.framework.dao.DeptMapper;

@Service
public class DeptService extends BaseService<Dept,DeptWhere>{

	@Autowired
	DeptMapper deptMapper;
	
	@Override
	public Object getMapper() {
		return deptMapper;
	}
}
