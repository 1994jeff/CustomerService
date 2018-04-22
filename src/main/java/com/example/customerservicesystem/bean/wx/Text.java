package com.example.customerservicesystem.bean.wx;

import java.io.Serializable;

public class Text implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String content;
	public Text(String text) {
		this.content = text;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Text [content=" + content + "]";
	}
}
