package com.example.customerservicesystem.bean.wx;

public class AccessTokenBean {

	/**
	 * 
	 * { "access_token":"ACCESS_TOKEN",
		"expires_in":7200,
		"refresh_token":"REFRESH_TOKEN",
		"openid":"OPENID",
		"scope":"SCOPE" }
	 * 
	 */
	
	private String expires_in;
	private String access_token;
	private String refresh_token;
	private String openid;
	private String scope;
	
	
	public AccessTokenBean(String expires_in, String access_token, String refresh_token, String openid, String scope) {
		super();
		this.expires_in = expires_in;
		this.access_token = access_token;
		this.refresh_token = refresh_token;
		this.openid = openid;
		this.scope = scope;
	}
	public String getExpires_in() {
		return expires_in;
	}
	public String getAccess_token() {
		return access_token;
	}
	public String getRefresh_token() {
		return refresh_token;
	}
	public String getOpenid() {
		return openid;
	}
	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	
	
}
