package com.example.customerservicesystem.bean;

import java.io.Serializable;
import java.util.Date;

public class KeyWord implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String keyWordNo;
	private String keyWord;
	private Date createTime;
	private Date updateTime;
	private String remark;
	public int getId() {
		return id;
	}
	public String getKeyWordNo() {
		return keyWordNo;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setKeyWordNo(String keyWordNo) {
		this.keyWordNo = keyWordNo;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "KeyWord [id=" + id + ", keyWordNo=" + keyWordNo + ", keyWord=" + keyWord + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", remark=" + remark + "]";
	}
	
}
