package com.chrhc.mybatis.handler.mapper.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import com.chrhc.mybatis.handler.domain.User;
import com.chrhc.mybatis.handler.domain.UserType;
import com.chrhc.mybatis.handler.mapper.UserMapper;

public class UserMapperTest {
	
	private static SqlSession sqlSession = null;
	
	@BeforeClass
	public static void doInitTest() throws Exception {
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		sqlSession = sqlSessionFactory.openSession(true);
	}
	
	@Test
	public void testInsert() throws Exception {
		User user = new User();
		user.setId(100);
		user.setName("test");
		user.setPassword("test");
		user.setUserType(UserType.STUDENT);
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.insertUser(user);
	}
	
	@Test
	public void testSelelctById() throws Exception {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.selectById(100);
		System.out.println(user);
	}
	
	@Test
	public void testSelelctByUserType() throws Exception {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> users = userMapper.selectByUserType(UserType.STUDENT);
		System.out.println(users);
	}

}
