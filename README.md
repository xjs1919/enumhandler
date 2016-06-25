# MyBatis通用枚举处理器 #

### MyBatis EnumHandler ###

[![Build Status](https://travis-ci.org/mybatis/mybatis-3.svg?branch=master)](https://travis-ci.org/mybatis/mybatis-3)
[![Coverage Status](https://coveralls.io/repos/mybatis/mybatis-3/badge.svg?branch=master&service=github)](https://coveralls.io/github/mybatis/mybatis-3?branch=master)
[![Dependency Status](https://www.versioneye.com/user/projects/56199c04a193340f320005d3/badge.svg?style=flat)](https://www.versioneye.com/user/projects/56199c04a193340f320005d3)
[![Maven central](https://maven-badges.herokuapp.com/maven-central/org.mybatis/mybatis/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.mybatis/mybatis)
[![License](http://img.shields.io/:license-apache-brightgreen.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)
[![Stack Overflow](http://img.shields.io/:stack%20overflow-mybatis-brightgreen.svg)](http://stackoverflow.com/questions/tagged/mybatis)
[![Project Stats](https://www.openhub.net/p/mybatis/widgets/project_thin_badge.gif)](https://www.openhub.net/p/mybatis)

![mybatis](http://mybatis.github.io/images/mybatis-logo.png)

----------

## Document: ##
	
----------

	描述：主要是为了对枚举进行通用处理，Mybatis提供的EnumTypeHandler和EnumOrdinalTypeHandler使用还是不够灵活。

----------
### 1. 使用举例 ###

	查询1：
	List<User> selectByUserType(UserType userType);
	<select id="selectByUserType" resultMap="BaseResultMap">
		select * from user_enum where user_type=#{userType,typeHandler=com.chrhc.mybatis.handler.EnumHandler}
	</select>
	查询2：
	User selectById(@Param("id") int id);
	<select id="selectById" resultMap="BaseResultMap">
		select * from user_enum where id = #{id}
	</select>
	<resultMap id="BaseResultMap" type="User">
		<id column="id" property="id"/>
		<result column="name" property="name"/>
		<result column="password" property="password"/>
		<result column="user_type" property="userType" typeHandler="com.chrhc.mybatis.handler.EnumHandler"/>
	</resultMap>
	插入：
	Integer insertUser(User user);
	<insert id="insertUser" parameterType="User">
		insert into user_enum(id, name, password, user_type)values(#{id}, #{name}, #{password}, #{userType,typeHandler=com.chrhc.mybatis.handler.EnumHandler})
	</insert>

----------

### 2.使用条件 ###

	枚举类需要实现com.chrhc.mybatis.handler.Identifiable接口，仅此而已。
	
----------

### 3.关于作者： ###
	作者QQ：605162215
	作者邮箱：605162215@qq.com
