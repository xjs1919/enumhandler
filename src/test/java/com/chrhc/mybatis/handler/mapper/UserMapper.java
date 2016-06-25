package com.chrhc.mybatis.handler.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chrhc.mybatis.handler.domain.User;
import com.chrhc.mybatis.handler.domain.UserType;

public interface UserMapper {
	
	Integer insertUser(User user);
	
	User selectById(@Param("id") int id);
	
	List<User> selectByUserType(UserType userType);
	
	Integer resetData();
	
}
