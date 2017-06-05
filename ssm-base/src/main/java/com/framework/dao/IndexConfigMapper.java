package com.framework.dao;

import com.framework.bean.IndexConfig;
import com.framework.bean.IndexConfigCondition;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IndexConfigMapper {
    long countByExample(IndexConfigCondition example);

    int deleteByExample(IndexConfigCondition example);

    int deleteByPrimaryKey(Integer id);

    int insert(IndexConfig record);

    int insertSelective(IndexConfig record);

    List<IndexConfig> selectByExample(IndexConfigCondition example);

    IndexConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IndexConfig record, @Param("example") IndexConfigCondition example);

    int updateByExample(@Param("record") IndexConfig record, @Param("example") IndexConfigCondition example);

    int updateByPrimaryKeySelective(IndexConfig record);

    int updateByPrimaryKey(IndexConfig record);
}