package com.framework.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.bean.IndexConfig;
import com.framework.bean.IndexConfigWhere;
import com.framework.dao.IndexConfigMapper;

@Service
public class IndexConfigService extends BaseService<IndexConfig, IndexConfigWhere>{

	@Autowired
	IndexConfigMapper indexConfigMapper;
	
	@Override
	public Object getMapper() {
		return indexConfigMapper;
	}
	
	public List<IndexConfig> getAll(){
		IndexConfigWhere where = new IndexConfigWhere();
		where.createCriteria().andStatusEqualTo(0);
		return this.queryForList(where);
	}
	
	public IndexConfig getByCode(String code){
		IndexConfigWhere where = new IndexConfigWhere();
		where.createCriteria().andStatusEqualTo(0).andCodeEqualTo(code);
		return this.queryForList(where).get(0);
	}
}
