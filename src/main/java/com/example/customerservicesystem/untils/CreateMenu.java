package com.example.customerservicesystem.untils;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.example.customerservicesystem.bean.wx.Button;
import com.example.customerservicesystem.bean.wx.ClickButton;
import com.example.customerservicesystem.bean.wx.Menu;
import com.example.customerservicesystem.bean.wx.SendBean;
import com.example.customerservicesystem.bean.wx.Text;
import com.example.customerservicesystem.bean.wx.ViewButton;
import com.google.gson.JsonObject;

import net.sf.json.JSONObject;

public class CreateMenu {

	public static String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	public static final String BASE_URL = "http://www.wq321.xyz/customerservicesystem/";
	
	//微信通过菜单获取openId
	//https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect
	public static final String PRE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+AccessTokenUtil.APP_ID+"&redirect_uri=";
	public static final String AFTER_URL = "&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
	

	public static void main(String[] args) {
		menu();
//		try {
//			sendMsgToUser("hahaha", "oPFDk1QFYUzriWOEtqVgdSQVtp3A");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	private static void menu() {
		try {
			String token = AccessTokenUtil.ACCESS_TOKEN;
			if("".equals(token)){
				token = AccessTokenUtil.getToken(AccessTokenUtil.GET_TOKEN_URL, AccessTokenUtil.APP_ID, AccessTokenUtil.SECRET );
			}
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
		System.out.println(jsonObject);
		if (jsonObject != null) {
			result = jsonObject.getInt("errcode");
		}
		return result;
	}
	
	 //通过此接口向微信用户发送消息 POST方式
    private static String SEND_MSG = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
	public static int sendMsgToUser(String text,String openId) throws ClientProtocolException, IOException {
		String token = AccessTokenUtil.ACCESS_TOKEN;
		if("".equals(token)){
			token = AccessTokenUtil.getToken(AccessTokenUtil.GET_TOKEN_URL, AccessTokenUtil.APP_ID, AccessTokenUtil.SECRET );
		}
		int result = 0;
		String url = SEND_MSG.replace("ACCESS_TOKEN", token);
		SendBean send = new SendBean();
		Text t = new Text(text);
		send.setText(t);
		send.setMsgtype("text");
		send.setTouser(openId);
		JSONObject jsonObject = WeixinUtil.httpRequest(url, "POST", JSONObject.fromObject(send).toString());
		System.out.println(jsonObject);
		System.out.println(JSONObject.fromObject(send).toString());
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
		user.setUrl(PRE_URL+BASE_URL + "userBinding/toBindUser.do"+AFTER_URL);
		ViewButton shop = new ViewButton();
		shop.setName("更换绑定门店");
		shop.setType("view");
		shop.setUrl(PRE_URL+BASE_URL + "userBinding/toBindShop.do"+AFTER_URL);

		eService.setSub_button(new Button[] { index, book, repair });
		userService.setSub_button(new Button[] { record, user, shop });
		menu.setButton(new Button[] { eService, userService });
		return menu;
	}
}
