package com.framework.dao;

import com.framework.bean.TestBean;
import com.framework.bean.TestBeanWhere;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestBeanMapper {
    long countByExample(TestBeanWhere example);

    int deleteByExample(TestBeanWhere example);

    int deleteByPrimaryKey(Integer id);

    int insert(TestBean record);

    int insertSelective(TestBean record);

    List<TestBean> selectByExample(TestBeanWhere example);

    TestBean selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TestBean record, @Param("example") TestBeanWhere example);

    int updateByExample(@Param("record") TestBean record, @Param("example") TestBeanWhere example);

    int updateByPrimaryKeySelective(TestBean record);

    int updateByPrimaryKey(TestBean record);
}