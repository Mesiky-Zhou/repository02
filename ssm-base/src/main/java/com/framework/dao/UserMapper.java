package com.framework.dao;

import com.framework.bean.User;
import com.framework.bean.UserWhere;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    long countByExample(UserWhere example);

    int deleteByExample(UserWhere example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserWhere example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserWhere example);

    int updateByExample(@Param("record") User record, @Param("example") UserWhere example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}