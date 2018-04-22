package com.example.customerservicesystem.bean.wx;

import java.io.Serializable;

public class SendBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String touser;
	private String msgtype;
	private Text text;
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	public Text getText() {
		return text;
	}
	public void setText(Text text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "SendBean [touser=" + touser + ", msgtype=" + msgtype + ", text=" + text + "]";
	}
}
