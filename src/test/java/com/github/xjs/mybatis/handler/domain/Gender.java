/**
 * 
 */
package com.github.xjs.mybatis.handler.domain;

import com.github.xjs.mybatis.handler.Identifiable;

/**
 * @author 605162215@qq.com
 *
 * 2016年9月20日 下午1:41:01
 */
public enum Gender implements Identifiable<Integer>{
	
	BOY(0), GIRL(1);
	
	private int gender;
	
	private Gender(int type){
		this.gender = type;
	}
	
	public Integer getId(){
		return this.gender;
	}
}
