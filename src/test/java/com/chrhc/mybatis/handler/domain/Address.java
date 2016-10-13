/**
 * 
 */
package com.chrhc.mybatis.handler.domain;

/**
 * @author 605162215@qq.com
 *
 * 2016年9月20日 下午1:42:52
 */
public class Address {
	private int id;
	private String addr;
	private Status status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", addr=" + addr + ", status=" + status + "]";
	}
	
}
