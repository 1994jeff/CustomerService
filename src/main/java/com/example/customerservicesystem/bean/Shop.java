package com.example.customerservicesystem.bean;

import java.io.Serializable;
import java.util.Date;

public class Shop implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String posNo;//pos机号
	private String userNo;//用户号
	private String brand;//门店品牌
	private String name;//门店名
	private String employee;//操作员账号名
	private String employeePsd;//操作员密码
	private String address;//门店地址
	private String remark;//电话
	private Date createTime;
	private Date updateTime;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPosNo() {
		return posNo;
	}
	public void setPosNo(String posNo) {
		this.posNo = posNo;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	public String getEmployeePsd() {
		return employeePsd;
	}
	public void setEmployeePsd(String employeePsd) {
		this.employeePsd = employeePsd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "Shop [id=" + id + ", posNo=" + posNo + ", userNo=" + userNo + ", brand=" + brand + ", name=" + name
				+ ", employee=" + employee + ", employeePsd=" + employeePsd + ", address=" + address + ", remark="
				+ remark + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
}
