# MyBatis通用枚举处理器 #

## 微信扫一扫关注公众号：爪哇优太儿
![扫一扫加关注](https://img-blog.csdnimg.cn/20190524100820287.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2dvbGRlbmZpc2gxOTE5,size_16,color_FFFFFF,t_7)

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
