package com.framework.test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.framework.bean.TestBean;
import com.framework.bean.TestBeanWhere;
import com.framework.service.TestBeanService;
import com.github.pagehelper.PageInfo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-main.xml"})
public class TestBeanServiceTest {

	@Autowired
	TestBeanService testBeanService;
	
	
	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void testInsert(){
		TestBean test = new TestBean();
		test.setName("úy‘á1");
		test.setCreateDate(new Date());
		this.testBeanService.save(test);
		
		System.out.println("≤Â»ÎÕÍ≥…");
	}
	
	@Test
	public void testSelect(){
		for(int i=0;i<1;i++){
			TestBean bean = this.testBeanService.get(3);
			System.out.println(bean.getName());
		}
		
		for(int i=0;i<1;i++){
			TestBeanWhere c = new TestBeanWhere();
			c.createCriteria().andIdEqualTo(3);
			List<TestBean> beans = this.testBeanService.queryForList(c);
			System.out.println(beans.size());
			System.out.println(beans.get(0).getName());
		}
		
		
	}
	
	@Test
	public void testSelectBySql(){
		String sql = "select * from cf_user where id>${id}";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", 900);
		List<Map<String,Object>> result = this.testBeanService.queryForList(sql, map);
		for(Map<String,Object> row : result){
			System.out.println(row);
		}
	}
	
	@Test
	public void testSelectByPage(){
		String sql = "select * from cf_user where id>${id}";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", 900);
		PageInfo<Map<String,Object>> result = this.testBeanService.queryForPage(sql, map, 1);
		System.out.println(result.getTotal());
		System.out.println(result.getPages());
		for(Map<String,Object> row : result.getList()){
			System.out.println(row);
		}
	}
	
	
}
