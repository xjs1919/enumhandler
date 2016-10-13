/**
 * 
 */
package com.github.xjs.mybatis.handler.domain;

/**
 * @author 605162215@qq.com
 *
 * 2016年9月20日 下午1:40:21
 */
public class Person {
	private int id;
	private String name;
	private Gender gender;
	private int addrId;
	private Address addr;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public int getAddrId() {
		return addrId;
	}
	public void setAddrId(int addrId) {
		this.addrId = addrId;
	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", gender=" + gender + ", addrId=" + addrId + ", addr=" + addr
				+ "]";
	}
	
}
