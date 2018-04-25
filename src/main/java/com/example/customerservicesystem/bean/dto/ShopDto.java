package com.example.customerservicesystem.bean.dto;

import java.io.Serializable;
import java.util.Date;

public class ShopDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String shopName;
	private String shopBrand;
	private String bookNum;
	private String userNo;
	private String recordNo;
	private String contactName;
	private String contactMobile;
	private String shopAddress;
	private String bookStatus;
	private String resolveResult;
	private Date createTime;
	private String type;
	private String reason;
	
	public String getResolveResult() {
		return resolveResult;
	}
	public void setResolveResult(String resolveResult) {
		this.resolveResult = resolveResult;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopBrand() {
		return shopBrand;
	}
	public void setShopBrand(String shopBrand) {
		this.shopBrand = shopBrand;
	}
	public String getBookNum() {
		return bookNum;
	}
	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getRecordNo() {
		return recordNo;
	}
	public void setRecordNo(String recordNo) {
		this.recordNo = recordNo;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactMobile() {
		return contactMobile;
	}
	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}
	public String getShopAddress() {
		return shopAddress;
	}
	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}
	public String getBookStatus() {
		return bookStatus;
	}
	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
