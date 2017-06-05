package com.framework.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.bean.IndexConfig;
import com.framework.bean.IndexConfigCondition;
import com.framework.dao.IndexConfigMapper;

@Service
public class IndexConfigService {

	@Autowired
	IndexConfigMapper indexConfigMapper;
	
	public List<IndexConfig> getAll(){
		IndexConfigCondition condition = new IndexConfigCondition();
		condition.createCriteria().andStatusEqualTo(0);
		return indexConfigMapper.selectByExample(condition);
	}
	
	public IndexConfig getByPrimaryKey(Integer id){
		return indexConfigMapper.selectByPrimaryKey(id);
	}
	
	public void updateByPrimaryKey(IndexConfig bean){
		indexConfigMapper.updateByPrimaryKeySelective(bean);
	}
	
	public void save(IndexConfig bean){
		indexConfigMapper.insertSelective(bean);
	}
	
	public void deleteByPrimaryKey(Integer id){
		indexConfigMapper.deleteByPrimaryKey(id);
	}
	
	public void deleteByBatch(List<Integer> ids){
		IndexConfigCondition condition = new IndexConfigCondition();
		condition.createCriteria().andIdIn(ids);
		indexConfigMapper.deleteByExample(condition);
	}
	
	
	public IndexConfig getByCode(String code){
		IndexConfigCondition condition = new IndexConfigCondition();
		condition.createCriteria().andStatusEqualTo(0).andCodeEqualTo(code);
		return indexConfigMapper.selectByExample(condition).get(0);
	}
}
