package com.yll.ssmm.mapper;

import com.yll.ssmm.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);
    
    User selectByName(String userName);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}