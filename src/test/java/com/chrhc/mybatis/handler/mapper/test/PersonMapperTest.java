package com.chrhc.mybatis.handler.mapper.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.exceptions.ExceptionFactory;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.io.ResolverUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.junit.BeforeClass;
import org.junit.Test;

import com.chrhc.mybatis.handler.EnumHandler;
import com.chrhc.mybatis.handler.Identifiable;
import com.chrhc.mybatis.handler.domain.Person;
import com.chrhc.mybatis.handler.mapper.PersonMapper;

public class PersonMapperTest {

	private static SqlSession sqlSession = null;
	private static String basePackage = "com.chrhc.mybatis.handler.domain";

	@BeforeClass
	public static void doInitTest() throws Exception {
		SqlSessionFactory sqlSessionFactory = buildSqlSessionFactory();
		sqlSession = sqlSessionFactory.openSession(true);
	}

	protected static SqlSessionFactory buildSqlSessionFactory() throws Exception {
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		try {
			XMLConfigBuilder parser = new XMLConfigBuilder(inputStream, null, null);
			Configuration config = parser.getConfiguration();
			scanEnums(config, basePackage);
			parser.parse();
			return new DefaultSqlSessionFactory(config);
		} catch (Exception e) {
			throw ExceptionFactory.wrapException("Error building SqlSession.", e);
		} finally {
			ErrorContext.instance().reset();
			try {
				inputStream.close();
			} catch (IOException e) {
			}
		}
	}

	private static void scanEnums(Configuration configuration, String basePackage) {
		ResolverUtil<Class<?>> resolverUtil = new ResolverUtil<Class<?>>();
		resolverUtil.find(new ResolverUtil.IsA(Identifiable.class), basePackage);
		Set<Class<? extends Class<?>>> mTypes = resolverUtil.getClasses();
		for (Class<?> javaTypeClass : mTypes) {
			System.out.println("scan enum:" + javaTypeClass);
			registerEnumHandler(configuration, javaTypeClass);
		}
	}

	private static void registerEnumHandler(org.apache.ibatis.session.Configuration configuration,
			Class<?> javaTypeClass) {
		if (javaTypeClass == Identifiable.class) {
			return;
		}
		TypeHandlerRegistry registry = configuration.getTypeHandlerRegistry();
		registry.register(javaTypeClass, EnumHandler.class);
//		try{
//            Field field = TypeHandlerRegistry.class.getDeclaredField("ALL_TYPE_HANDLERS_MAP");
//            field.setAccessible(true);
//            Map<Class<?>, TypeHandler<?>> map = (Map<Class<?>, TypeHandler<?>>)field.get(registry);
//            map.remove(EnumHandler.class);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
	}

	@Test
	public void testSelectPerson() throws Exception {
		PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
		List<Person> users = mapper.selectPerson();
		System.out.println(users);
	}
	
	@Test
	public void testSelectPersonWithAddress() throws Exception {
		PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
		List<Person> users = mapper.selectPersonWithAddress();
		System.out.println(users);
	}
}
