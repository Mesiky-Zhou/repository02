package com.framework.service;

import java.io.Serializable;
//import java.lang.reflect.Method;
//import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.utils.ReflectUtils;
  
  
@Service  
public abstract class BaseServiceBak<T,C> extends SqlSessionDaoSupport implements Serializable{  
      
	private static final long serialVersionUID = 7623507504198633838L;  
	  
    //private final String POSTFIX = "Mapper";
    
   /* private final String deleteByExample = ".deleteByExample";  
    private final String deleteByPrimaryKey = ".deleteByPrimaryKey";  
  
  
    private final String selectByExample = "selectByExample";  
  
    
    private final String updateByExampleSelective = ".updateByExampleSelective";  
    private final String updateByExample = ".updateByExample";
    private final String updateByPrimaryKeySelective = ".updateByPrimaryKeySelective";
    private final String updateByPrimaryKey = ".updateByPrimaryKey";*/
      
    @Autowired  
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {  
        super.setSqlSessionFactory(sqlSessionFactory);  
    }  
    
    public abstract Object getMapper();
    
    public String getNameSpace(){
    	return ReflectUtils.getInterfaces(this.getMapper())[0].getName();
    }
    
    
    
    /*GenericsUtils为工具类，请见下方代码 
      泛型获得XXXEntity，将其转换为XXXEntityDao，具体操作替换掉Entity变成XXXDao，对应Mapper.xml中的namespace命名 
    @SuppressWarnings({ "unchecked", "rawtypes" })  
    public String getNampSpace() {  
        Class<T> clazz = (Class)GenericsUtils.getSuperClassGenricType(this.getClass());  
        String simpleName = clazz.getSimpleName() + POSTFIX; 
        System.out.println(simpleName);
        //return simpleName;  
        return "com.framework.dao.TestBean"+ POSTFIX;
    }  */
      
    public int insert(T record) {  
        return getSqlSession().insert(this.getNameSpace() + ".insert", record);  
    }  
    public int insertSelective(T record) { 
    	return getSqlSession().insert(this.getNameSpace() + ".insertSelective", record);    
    }  
  
   
    
    @SuppressWarnings("unchecked")
	public T selectByPrimaryKey(Integer id) {
    	
    	return (T)ReflectUtils.execMethod(this.getMapper(), "selectByPrimaryKey", 
    			new Class[]{Integer.class}, new Object[]{id});
    	
        /*return getSqlSession().selectOne(  
                (this.getNampSpace().contains("Entity") ? this.getNampSpace().replace("Entity", "")  
                        : this.getNampSpace()) + _SELECTBYPRIMARYKEY, id); */ 
    } 
    //@SuppressWarnings("unchecked")
	/*public List<T> selectByCondition(C condition){
    	Object obj = this.getMapper();
    	Method method = this.getMethod(obj, "selectByExample", condition.getClass());
    	return (List<T>)this.invokeMethod(method, obj, condition);
    }*/
  
    /* 
    public int updateByPrimaryKey(T record) {  
        return getSqlSession().update(  
                (this.getNampSpace().contains("Entity") ? this.getNampSpace().replace("Entity", "")  
                        : this.getNampSpace()) + _UPDATEBYPRIMARYKEY, record);  
    }  
  
    public int updateByPrimaryKeySelective(T record) {  
        return getSqlSession().update(  
                (this.getNampSpace().contains("Entity") ? this.getNampSpace().replace("Entity", "")  
                        : this.getNampSpace()) + _UPDATEBYPRIMARYKEYSELECTIVE, record);  
    }  
  
    public int deleteByPrimaryKey(PK id) {  
        return getSqlSession().delete(  
                (this.getNampSpace().contains("Entity") ? this.getNampSpace().replace("Entity", "")  
                        : this.getNampSpace()) + _DELETEBYPRIMARYKEY, id);  
    }  
  
    @SuppressWarnings({ "rawtypes", "unchecked" })  
    public PageInfo<T> pageFind(String statementKey, PageForm pageForm, Object parameter,  
            Boolean isSimplePage) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {  
        Map params = new HashMap();  
        if (parameter != null) {  
            if (parameter instanceof Map) {  
                params.putAll((Map) parameter);  
            } else {  
                Map parameterObject = PropertyUtils.describe(parameter);  
                params.putAll(parameterObject);  
            }  
        }  
        PageHelper.startPage(pageForm.getPage(), pageForm.getRows());  
        List<T> list = getSqlSession().selectList(statementKey, params);  
        PageInfo<T> pageInfo = new PageInfo(list);  
  
        return pageInfo;  
    }  
  
    @SuppressWarnings({ "rawtypes", "unchecked" })  
    public List<T> findTop(int top, String statementKey, Object parameter) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {  
        Map params = new HashMap();  
        if (parameter != null) {  
            if (parameter instanceof Map) {  
                params.putAll((Map) parameter);  
            } else {  
                Map parameterObject = PropertyUtils.describe(parameter);  
                params.putAll(parameterObject);  
            }  
        }  
        List<T> list = getSqlSession().selectList(statementKey, params, new RowBounds(0, top));  
        return list;  
    }  
  
    public T findTopOne(String statementKey, Object parameter) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {  
        List<T> list = findTop(1, statementKey, parameter);  
        return CollectionUtils.isEmpty(list) ? null : list.get(0);  
    }  
      
    @SuppressWarnings({ "rawtypes", "unchecked" })  
    public <M> PageInfo<M> pageFindModel(String statementKey, PageForm pageForm, Object parameter) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {  
        Map params = new HashMap();  
        if (parameter != null) {  
            if (parameter instanceof Map) {  
                params.putAll((Map) parameter);  
            } else {  
                Map parameterObject = PropertyUtils.describe(parameter);  
                params.putAll(parameterObject);  
            }  
        }  
        PageHelper.startPage(pageForm.getPage(), pageForm.getRows());  
        List<M> list = getSqlSession().selectList(statementKey, params);  
        PageInfo<M> pageInfo = new PageInfo(list);  
  
        return pageInfo;  
    }  */
}  
