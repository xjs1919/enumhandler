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
public enum Status implements Identifiable<Integer>{
	
	OK(0), DELETED(1);
	
	private int status;
	
	private Status(int type){
		this.status = type;
	}
	
	public Integer getId(){
		return this.status;
	}
}
