package com.framework.dao;

import com.framework.bean.Dept;
import com.framework.bean.DeptWhere;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    long countByExample(DeptWhere example);

    int deleteByExample(DeptWhere example);

    int deleteByPrimaryKey(Integer id);

    int insert(Dept record);

    int insertSelective(Dept record);

    List<Dept> selectByExample(DeptWhere example);

    Dept selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Dept record, @Param("example") DeptWhere example);

    int updateByExample(@Param("record") Dept record, @Param("example") DeptWhere example);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
}