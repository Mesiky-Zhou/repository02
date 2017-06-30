package com.framework.dao;

import com.framework.bean.IndexConfig;
import com.framework.bean.IndexConfigWhere;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IndexConfigMapper {
    long countByExample(IndexConfigWhere example);

    int deleteByExample(IndexConfigWhere example);

    int deleteByPrimaryKey(Integer id);

    int insert(IndexConfig record);

    int insertSelective(IndexConfig record);

    List<IndexConfig> selectByExample(IndexConfigWhere example);

    IndexConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IndexConfig record, @Param("example") IndexConfigWhere example);

    int updateByExample(@Param("record") IndexConfig record, @Param("example") IndexConfigWhere example);

    int updateByPrimaryKeySelective(IndexConfig record);

    int updateByPrimaryKey(IndexConfig record);
}