package com.example.customerservicesystem.untils;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.example.customerservicesystem.bean.wx.Button;
import com.example.customerservicesystem.bean.wx.ClickButton;
import com.example.customerservicesystem.bean.wx.Menu;
import com.example.customerservicesystem.bean.wx.ViewButton;

import net.sf.json.JSONObject;

public class CreateMenu {

	public static String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

	public static void main(String[] args) throws ClientProtocolException, IOException {
		String token = AccessTokenUtil.getToken(AccessTokenUtil.GET_TOKEN_URL, AccessTokenUtil.APP_ID, AccessTokenUtil.SECRET);
		System.out.println("Access_Token为:"+AccessTokenUtil.GET_TOKEN_URL);
		String menu = JSONObject.fromObject(initMenu()).toString();
		int result = createMenu(token, menu);
		if(result==0){
			System.out.println("菜单创建成功！");
		}else {
			System.out.println("菜单创建失败！");
		}
	}

	public static int createMenu(String token, String menu) throws ClientProtocolException, IOException {
		int result = 0;
		String url = CREATE_MENU_URL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = WeixinUtil.httpRequest(url, "post", menu);
		if (jsonObject != null) {
			result = jsonObject.getInt("errcode");
		}
		return result;
	}

	public static Menu initMenu() {
		Menu menu = new Menu();
		ClickButton button11 = new ClickButton();
		button11.setName("E服务1");
		button11.setType("click");
		button11.setKey("11");
		ClickButton button12 = new ClickButton();
		button12.setName("用户中心1");
		button12.setType("click");
		button12.setKey("12");
		ViewButton button21 = new ViewButton();
		button21.setName("首页");
		button21.setType("view");
		button21.setUrl("http://www.baidu.com");
		ViewButton button22 = new ViewButton();
		button22.setName("报修申请");
		button22.setType("view");
		button22.setUrl("http://www.baidu.com");
		ViewButton button33 = new ViewButton();
		button33.setName("订纸申请");
		button33.setType("view");
		button33.setUrl("http://www.baidu.com");
		ClickButton button31 = new ClickButton();
		button31.setName("用户绑定");
		button31.setType("click");
		button31.setKey("31");
		Button button1 = new Button();
		button1.setName("E服务"); // 将11/12两个button作为二级菜单封装第一个一级菜单
		button1.setSub_button(new Button[] { button11, button12 });
		Button button2 = new Button();
		button2.setName("用户中心"); // 将21/22两个button作为二级菜单封装第二个二级菜单
		button2.setSub_button(new Button[] { button11, button12 });
		menu.setButton(new Button[] { button1, button2, button31 });// 将31Button直接作为一级菜单
		return menu;
	}
}
