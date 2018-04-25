package com.example.customerservicesystem.bean;

import java.io.Serializable;
import java.util.Date;

public class Result implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String resultNo;
	private String recordNo;
	private String reason;
	private String type;
	private String replyMsg;
	private String goods;
	private String remark;
	private String resolveTime;
	private Date createTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getResultNo() {
		return resultNo;
	}
	public void setResultNo(String resultNo) {
		this.resultNo = resultNo;
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
	public String getReplyMsg() {
		return replyMsg;
	}
	public void setReplyMsg(String replyMsg) {
		this.replyMsg = replyMsg;
	}
	public String getGoods() {
		return goods;
	}
	public void setGoods(String goods) {
		this.goods = goods;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getResolveTime() {
		return resolveTime;
	}
	public void setResolveTime(String resolveTime) {
		this.resolveTime = resolveTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Result [id=" + id + ", resultNo=" + resultNo + ", recordNo=" + recordNo + ", reason=" + reason
				+ ", type=" + type + ", replyMsg=" + replyMsg + ", goods=" + goods + ", remark=" + remark
				+ ", resolveTime=" + resolveTime + ", createTime=" + createTime + "]";
	}
}
