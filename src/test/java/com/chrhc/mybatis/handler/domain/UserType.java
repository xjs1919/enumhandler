/**
 * 
 */
package com.chrhc.mybatis.handler.domain;

import com.chrhc.mybatis.handler.Identifiable;

/**
 * @author 605162215@qq.com
 *
 * 2016年6月25日 上午11:39:26
 */
public enum UserType implements Identifiable<Integer> {
	
	TEACHER(1), STUDENT(2);
	
	private int type;
	
	private UserType(int type){
		this.type = type;
	}
	
	@Override
	public Integer getId(){
		return this.type;
	}
	
}
