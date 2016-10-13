package com.github.xjs.mybatis.handler.mapper;

import java.util.List;

import com.github.xjs.mybatis.handler.domain.Person;

public interface PersonMapper {
	
	public List<Person> selectPersonWithAddress();
	
	public List<Person> selectPerson();
}
