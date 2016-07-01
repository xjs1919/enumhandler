/**
 * 
 */
package com.chrhc.mybatis.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.EnumSet;

import org.apache.ibatis.type.Alias;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

/**
 * @author 605162215@qq.com
 *
 *         2016年6月25日 上午11:59:11
 */
@Alias("EnumHandler")
public class EnumHandler<E extends Enum<E> & Identifiable<K>, K> extends BaseTypeHandler<E> {

	private Class<E> type;

	public EnumHandler(Class<E> type) {
		if (type == null) {
			throw new IllegalArgumentException("Type argument cannot be null");
		}
		this.type = type;
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
		if (jdbcType == null) {
			K id = parameter.getId();
			if(id instanceof Integer || id instanceof Short || id instanceof Character || id instanceof Byte){
				ps.setInt(i, (Integer)id);
			}else if(id instanceof String){
				ps.setString(i, (String)id);
			}else if(id instanceof Boolean){
				ps.setBoolean(i, (Boolean)id);
			}else if(id instanceof Long){
				ps.setLong(i, (Long)id);
			}else if(id instanceof Double){
				ps.setDouble(i, (Double)id);
			}else if(id instanceof Float){
				ps.setFloat(i, (Float)id);
			}else{
				throw new RuntimeException("unsupported [id] type of enum");
			}
		} else {
			ps.setObject(i, parameter.getId(), jdbcType.TYPE_CODE); // see r3589
		}
	}

	@Override
	public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
		String s = rs.getString(columnName);
		return toEnum(s);
	}

	@Override
	public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		String s = rs.getString(columnIndex);
		return toEnum(s);
	}

	@Override
	public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		String s = cs.getString(columnIndex);
		return toEnum(s);
	}
	
	private E toEnum(String id){
		EnumSet<E> set = EnumSet.allOf(type);
		if (set == null || set.size() <= 0) {
			return null;
		}
		for (E e : set) {
			K k = e.getId();
			if(k != null){
				if(k.toString().equals(id)){
					return e;
				}
			}
		}
		return null;
	}
}