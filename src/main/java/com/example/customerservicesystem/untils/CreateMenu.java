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
	public static final String BASE_URL = "http://www.wq321.xyz/";
	
	//微信通过菜单获取openId
	public static final String PRE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+AccessTokenUtil.APP_ID+"&redirect_uri=";
	public static final String AFTER_URL = "?action=viewtest&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
	

	public static void main(String[] args) {
		try {
			String token = AccessTokenUtil.getToken(AccessTokenUtil.GET_TOKEN_URL, AccessTokenUtil.APP_ID,
					AccessTokenUtil.SECRET);
			String menu = JSONObject.fromObject(initMenu()).toString();
			System.out.println(menu.toString());
			// int result =
			// createMenu("8_D_uyWve6ptavnOOmQsFneCVvDoDcmOeKdHrA-2s4sXVNFaUQ0WxYyz9V9ywhTOAfbHsbCg4Pk7OGmW5lVZFNOr6ikuTxvg1OQQgNeuv_WMRWVVx40Jwn9B5twYHxPkHaSeXsnzG9aXuftwDCOXBgAEAWFJ",
			// menu);
			int result = createMenu(token, menu);
			if (result == 0) {
				System.out.println("菜单创建成功！" + result);
			} else {
				System.out.println("菜单创建失败！" + result);
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
		System.out.println(jsonObject == null ? "null" : "not null");
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
		index.setUrl(PRE_URL+BASE_URL+AFTER_URL);
		ViewButton book = new ViewButton();
		book.setName("订纸申请");
		book.setType("view");
		book.setUrl(PRE_URL+BASE_URL + "book/toWantBook.do"+AFTER_URL);
		ViewButton repair = new ViewButton();
		repair.setName("报修申请");
		repair.setType("view");
		repair.setUrl(PRE_URL+BASE_URL + "repair/toRepair.do"+AFTER_URL);

		ViewButton record = new ViewButton();
		record.setName("我的申请记录");
		record.setType("view");
		record.setUrl(PRE_URL+BASE_URL + "repair/toMoreRecord.do"+AFTER_URL);
		ViewButton user = new ViewButton();
		user.setName("绑定个人信息");
		user.setType("view");
		user.setUrl(PRE_URL+BASE_URL + "userBinding/toBindUser.do");
		ViewButton shop = new ViewButton();
		shop.setName("更换绑定门店");
		shop.setType("view");
		shop.setUrl(PRE_URL+BASE_URL + "userBinding/toBindShop.do");

		eService.setSub_button(new Button[] { index, book, repair });
		userService.setSub_button(new Button[] { record, user, shop });
		menu.setButton(new Button[] { eService, userService });
		return menu;
	}
}
