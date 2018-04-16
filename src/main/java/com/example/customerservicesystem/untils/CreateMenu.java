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

	public static void main(String[] args) {
		try {
			String token = AccessTokenUtil.getToken(AccessTokenUtil.GET_TOKEN_URL, AccessTokenUtil.APP_ID, AccessTokenUtil.SECRET);
			System.out.println("Access_Token为:"+AccessTokenUtil.ACCESS_TOKEN);
			String menu = JSONObject.fromObject(initMenu()).toString();
			int result = createMenu(token, menu);
			if(result==0){
				System.out.println("菜单创建成功！"+result);
			}else {
				System.out.println("菜单创建失败！"+result);
			}
		} catch (ClientProtocolException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
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
		ClickButton eService = new ClickButton();
		
		return menu;
	}
}
