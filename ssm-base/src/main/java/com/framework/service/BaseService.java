package com.framework.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.utils.GenericsUtils;
import com.framework.utils.ReflectUtils;
import com.github.abel533.sql.SqlMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
  
  
@Service 
@SuppressWarnings("unused")
public abstract class BaseService<T,W> extends SqlSessionDaoSupport{  
      
    @Autowired  
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {  
        super.setSqlSessionFactory(sqlSessionFactory);  
    }  
    public abstract Object getMapper();
    private String getNameSpace(){
    	return ReflectUtils.getInterfaces(this.getMapper())[0].getName();
    }
    
    
	private int insert(T record) {  
        return getSqlSession().insert(this.getNameSpace() + ".insert", record);  
    }  
    private int insertSelective(T record) { 
    	return getSqlSession().insert(this.getNameSpace() + ".insertSelective", record);    
    }  
  
   
    private long countByExample(W where){
    	return (long)ReflectUtils.execMethod(this.getMapper(), "countByExample", 
    			new Class[]{where.getClass()}, new Object[]{where});
    }
    
    
    @SuppressWarnings("unchecked")
	private T selectByPrimaryKey(Integer id) {
    	
    	return (T)ReflectUtils.execMethod(this.getMapper(), "selectByPrimaryKey", 
    			new Class[]{Integer.class}, new Object[]{id});
    } 
    @SuppressWarnings("unchecked")
	private List<T> selectByWhere(W where){
    	return (List<T>)ReflectUtils.execMethod(this.getMapper(), "selectByExample", 
    			new Class[]{where.getClass()}, new Object[]{where});
    }
    
    private int deleteByWhere_(W where){
    	return (int)ReflectUtils.execMethod(this.getMapper(), "deleteByExample", 
    			new Class[]{where.getClass()}, new Object[]{where});
    }

    private int deleteByPrimaryKey(Integer id){
    	return (int)ReflectUtils.execMethod(this.getMapper(), "deleteByPrimaryKey", 
    			new Class[]{Integer.class}, new Object[]{id});
    }
    
    private int updateByPrimaryKey(T record){
    	return (int)ReflectUtils.execMethod(this.getMapper(), "updateByPrimaryKey", 
    			new Class[]{record.getClass()}, new Object[]{record});
    }
    
    private int updateByPrimaryKeySelective(T record){
    	return (int)ReflectUtils.execMethod(this.getMapper(), "updateByPrimaryKeySelective", 
    			new Class[]{record.getClass()}, new Object[]{record});
    }
    
    private int updateByWhere_( T record,  W where){
    	return (int)ReflectUtils.execMethod(this.getMapper(), "updateByExample", 
    			new Class[]{record.getClass(),where.getClass()}, new Object[]{record,where});
    }
    
    private int updateByWhereSelective(T record, W where){
    	return (int)ReflectUtils.execMethod(this.getMapper(), "updateByExampleSelective", 
    			new Class[]{record.getClass(),where.getClass()}, new Object[]{record,where});
    }

    

    //-----------------------外部调用方法satart---------------------------------------

    public int save(T record){
    	return this.insertSelective(record);
    }
    
    public T get(Integer id){
    	return this.selectByPrimaryKey(id);
    }
    
    public int delete(Integer id){
    	return  this.deleteByPrimaryKey(id);
    }
    
    public int deleteByWhere(W where){
    	return this.deleteByWhere_(where);
    }
    
    @SuppressWarnings("unchecked")
	public int deleteByIds(List<Integer> ids){
    	Class<W> clazz = GenericsUtils.getSuperClassGenricType(this.getClass(), 1);
    	Object obj = null;
		try {
			obj = clazz.newInstance();
			Object c = ReflectUtils.execMethod(obj, "createCriteria", null, null);
	    	c = ReflectUtils.execMethod(c, "andIdIn", new Class[]{List.class} , new Object[]{ids});
	    	
	    	W where = (W)obj;
	    	return this.deleteByWhere(where);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
    	return -1;
    }
    
    
    public int update(T record){
    	return this.updateByPrimaryKeySelective(record);
    }
    
    public int updateByWhere(T record, W where){
    	return this.updateByWhereSelective(record, where);
    }
    
    public List<T> queryForList(W where){
    	return this.selectByWhere(where);
    }
    
    public List<Map<String,Object>> queryForList(String sql, Map<String,Object> params){
    	SqlMapper sqlMapper = new SqlMapper(this.getSqlSession());
    	return sqlMapper.selectList(sql, params);
    }
    
	public PageInfo<T> queryForPage(W where, int pageNo, int pageSize)  {  
        PageHelper.startPage(pageNo, pageSize);  
        List<T> list = this.selectByWhere(where);  
        PageInfo<T> pageInfo = new PageInfo<T>(list,5);  
  
        return pageInfo;  
    }
    
	public PageInfo<T> queryForPage(W where, int pageNo)  {  
        PageHelper.startPage(pageNo, 10);  
        List<T> list = this.selectByWhere(where);  
        PageInfo<T> pageInfo = new PageInfo<T>(list,5);  
  
        return pageInfo;  
    }
	
	public PageInfo<Map<String,Object>> queryForPage(String sql, Map<String,Object> params, int pageNo, int pageSize)  {  
        PageHelper.startPage(pageNo, pageSize);  
        List<Map<String,Object>> list = this.queryForList(sql, params);  
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<Map<String,Object>>(list,5);  
  
        return pageInfo;  
    }
    
    public PageInfo<Map<String,Object>> queryForPage(String sql, Map<String,Object> params, int pageNo)  {  
        PageHelper.startPage(pageNo, 10);  
        List<Map<String,Object>> list = this.queryForList(sql, params);  
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<Map<String,Object>>(list,5);  
  
        return pageInfo;  
    }
    
    //-----------------------外部调用方法end   ---------------------------------------
   
}  
