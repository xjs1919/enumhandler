package com.chrhc.mybatis.handler.mapper;

import java.util.List;

import com.chrhc.mybatis.handler.domain.Person;

public interface PersonMapper {
	
	public List<Person> selectPersonWithAddress();
	
	public List<Person> selectPerson();
}
