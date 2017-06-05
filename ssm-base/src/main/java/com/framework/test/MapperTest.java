package com.framework.test;

import java.util.Date;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.framework.bean.IndexConfig;
import com.framework.bean.User;
import com.framework.dao.DeptMapper;
import com.framework.dao.IndexConfigMapper;
import com.framework.dao.UserMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-main.xml"})
public class MapperTest {

	@Autowired
	DeptMapper deptMapper;
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	IndexConfigMapper indexConfigMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void testInsert(){
		/*CfDept dept = new CfDept();
		dept.setName("������");
		dept.setCreateTime(new Date());
		cfDeptMapper.insertSelective(dept);
		
		dept = new CfDept();
		dept.setName("���Բ�");
		dept.setCreateTime(new Date());
		cfDeptMapper.insertSelective(dept);*/
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		for(int i=0;i<1000;i++){
			String uuid = UUID.randomUUID().toString().substring(0,6)+i;
			User user = new User();
			user.setUserName(uuid);
			user.setPassword("123");
			user.setGendar("F");
			user.setEmail(uuid+"@test.com");
			user.setDeptId(1);
			user.setCreateTime(new Date());
			
			userMapper.insertSelective(user);
		}
		System.out.println("�����������");
	}
	
	@Test
	public void testIndexConfig(){
		IndexConfig config = new IndexConfig();
		config.setCode("userIndex");
		config.setIndexTitle("�û�������");
		config.setPageSize(10);
		config.setRestUrl("/sysmgr/users");
		config.setGridConfig("#:id,�û���:userName,�Ա�:gendar:colProcFunForGendar,����:email,����ʱ��:createTime");
		String addConfig = "�û���:userName:text:[ph=�������û���],����:password:password:[ph=����������],�Ա�:gendar:radio:[kv=��-M@Ů-F],����:email:text:[ph=����������],��������:deptId:select:[url=/sysmgr/depts/forInitSelect&text=name&value=id]";
		config.setAddConfig(addConfig);
		config.setUpdateConfig(addConfig);
		config.setViewConfig("");
		config.setStatus(0);
		config.setCreateTime(new Date());
		config.setUpdateTime(new Date());
		
		indexConfigMapper.insertSelective(config);
		
	}
}
