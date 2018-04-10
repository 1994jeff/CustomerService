package com.example.customerservicesystem.bean;

import java.io.Serializable;
import java.util.Date;

public class ApplyRecord implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String recordNo;
	private String type;//0申请报修,1申请订纸
	private String reason;
	private String status;//0未处理,1已处理
	private String userNo;
	private String applyName;
	private String applyMobile;//订纸卷数或者处理状态
	private Date createTime;
	private Date updateTime;
	private String remark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRecordNo() {
		return recordNo;
	}
	public void setRecordNo(String recordNo) {
		this.recordNo = recordNo;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getApplyName() {
		return applyName;
	}
	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}
	public String getApplyMobile() {
		return applyMobile;
	}
	public void setApplyMobile(String applyMobile) {
		this.applyMobile = applyMobile;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "ApplyRecord [id=" + id + ", recordNo=" + recordNo + ", type=" + type + ", reason=" + reason
				+ ", status=" + status + ", userNo=" + userNo + ", applyName=" + applyName + ", applyMobile="
				+ applyMobile + ", createTime=" + createTime + ", updateTime=" + updateTime + ", remark=" + remark
				+ "]";
	}
}