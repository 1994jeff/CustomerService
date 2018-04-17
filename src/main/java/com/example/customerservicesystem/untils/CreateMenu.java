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
	public static final String BASE_URL = "http://jeff.geekare.com/";

	public static void main(String[] args) {
		try {
			//String token = AccessTokenUtil.getToken(AccessTokenUtil.GET_TOKEN_URL, AccessTokenUtil.APP_ID, AccessTokenUtil.SECRET);
			String menu = JSONObject.fromObject(initMenu()).toString();
			System.out.println(menu.toString());
			int result = createMenu("8_77GmH1XpO_3lMjl8uRM0M9AXVoXWEEoTva_xAra6x8mhptKdysdblwWkm3LIiPTauYbjGyB-Znn4t7gznbvXcgWnzH0Ig_Mr3C66NjNBFia648xOQ0sDAqQgHvIVGRgAEADOZ", menu);
			//int result = createMenu(token, menu);
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
		JSONObject jsonObject = WeixinUtil.httpRequest(url, "POST", menu);
		System.out.println(jsonObject==null?"null":"not null");
		if (jsonObject != null) {
			result = jsonObject.getInt("errcode");
		}
		return result;
	}

	public static Menu initMenu() {
		Menu menu = new Menu();
		ClickButton eService = new ClickButton();
		eService.setName("E服务");
		eService.setType("click");
		eService.setKey("1");
		ClickButton userService = new ClickButton();
		userService.setName("用户中心");
		userService.setType("click");
		userService.setKey("2");
		
		ViewButton index = new ViewButton();
		index.setName("首页");
		index.setType("view");
		index.setUrl(BASE_URL);
		ViewButton book = new ViewButton();
		book.setName("订纸申请");
		book.setType("view");
		book.setUrl(BASE_URL+"book/toWantBook.do");
		ViewButton repair = new ViewButton();
		repair.setName("报修申请");
		repair.setType("view");
		repair.setUrl(BASE_URL+"repair/toRepair.do");
		
		ViewButton record = new ViewButton();
		record.setName("我的申请记录");
		record.setType("view");
		record.setUrl(BASE_URL+"repair/toMoreRecord.do");
		ViewButton user = new ViewButton();
		user.setName("绑定个人信息");
		user.setType("view");
		user.setUrl(BASE_URL+"userBinding/toBindUser.do");
		ViewButton shop = new ViewButton();
		shop.setName("更换绑定门店");
		shop.setType("view");
		shop.setUrl(BASE_URL+"userBinding/toBindShop.do");
		
		eService.setSub_button(new Button[] {index,book,repair});
		userService.setSub_button(new Button[] {record,user,shop});
		menu.setButton(new Button[] {eService,userService});
		return menu;
	}
}
