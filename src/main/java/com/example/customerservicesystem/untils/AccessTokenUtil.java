package com.example.customerservicesystem.untils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.example.customerservicesystem.bean.wx.AccessTokenBean;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class AccessTokenUtil {
    public static final String GET_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";
    public static final String APP_ID = "wx33b5b45b527827a4";
    public static final String SECRET = "440512ecedcaecb27885828360e5eff4";
    public static String ACCESS_TOKEN = "";
    private static HttpClient client;
    
    // 获取token
    @SuppressWarnings("finally")
    public static String getToken(String apiurl, String appid, String secret) {
        String turl = String.format("%s?grant_type=client_credential&appid=%s&secret=%s", apiurl, appid, secret);
        client = new DefaultHttpClient();
        HttpGet get = new HttpGet(turl);
        JsonParser jsonparer = new JsonParser();// 初始化解析json格式的对象
        String result = null;
        try {
            HttpResponse res = client.execute(get);
            String responseContent = null; // 响应内容
            HttpEntity entity = res.getEntity();
            responseContent = EntityUtils.toString(entity, "UTF-8");
            JsonObject json = jsonparer.parse(responseContent).getAsJsonObject();
            // 将json字符串转换为json对象
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                if (json.get("errcode") != null) {// 错误时微信会返回错误码等信息，{"errcode":40013,"errmsg":"invalid appid"}
                	System.out.println(json);
                } else {// 正常情况下{"access_token":"ACCESS_TOKEN","expires_in":7200}
                    result = json.get("access_token").getAsString();
                	System.out.println(json);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接 ,释放资源
            client.getConnectionManager().shutdown();
            ACCESS_TOKEN = result;
            return result;
        }
    }

    //通过code获取AccessToken
    @SuppressWarnings("finally")
    public static AccessTokenBean getAccessToken(String code) {
    	AccessTokenBean bean = null;
        String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+AccessTokenUtil.APP_ID+"&secret="+AccessTokenUtil.SECRET+"&code="+code+"&grant_type=authorization_code";
        client = new DefaultHttpClient();
        HttpGet get = new HttpGet(ACCESS_TOKEN_URL);
        JsonParser jsonparer = new JsonParser();// 初始化解析json格式的对象
        try {
            HttpResponse res = client.execute(get);
            String responseContent = null; // 响应内容
            HttpEntity entity = res.getEntity();
            responseContent = EntityUtils.toString(entity, "UTF-8");
            JsonObject json = jsonparer.parse(responseContent).getAsJsonObject();
            // 将json字符串转换为json对象
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                if (json.get("errcode") != null) {// 错误时微信会返回错误码等信息，{"errcode":40013,"errmsg":"invalid appid"}
                	System.out.println(json);
                } else {// 正常情况下{"access_token":"ACCESS_TOKEN","expires_in":7200}
                    String access_token = json.get("access_token").getAsString();
                    String expires_in = json.get("expires_in").getAsString();
                    String openid = json.get("openid").getAsString();
                    String refresh_token = json.get("refresh_token").getAsString();
                    String scope = json.get("scope").getAsString();
                    bean = new AccessTokenBean(expires_in,access_token,refresh_token,openid,scope);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接 ,释放资源
            client.getConnectionManager().shutdown();
        }
        return bean;
    }
    
    //刷新access_token
    //https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN
    public static AccessTokenBean getAccessTokenByRefreshToken(String REFRESH_TOKEN) {
    	AccessTokenBean bean = null;
        String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid="+AccessTokenUtil.APP_ID+"&grant_type=refresh_token&refresh_token="+REFRESH_TOKEN;
        client = new DefaultHttpClient();
        HttpGet get = new HttpGet(ACCESS_TOKEN_URL);
        JsonParser jsonparer = new JsonParser();// 初始化解析json格式的对象
        try {
            HttpResponse res = client.execute(get);
            String responseContent = null; // 响应内容
            HttpEntity entity = res.getEntity();
            responseContent = EntityUtils.toString(entity, "UTF-8");
            JsonObject json = jsonparer.parse(responseContent).getAsJsonObject();
            // 将json字符串转换为json对象
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                if (json.get("errcode") != null) {// 错误时微信会返回错误码等信息，{"errcode":40013,"errmsg":"invalid appid"}
                	System.out.println(json);
                } else {// 正常情况下{"access_token":"ACCESS_TOKEN","expires_in":7200}
                    String access_token = json.get("access_token").getAsString();
                    String expires_in = json.get("expires_in").getAsString();
                    String openid = json.get("openid").getAsString();
                    String refresh_token = json.get("refresh_token").getAsString();
                    String scope = json.get("scope").getAsString();
                    bean = new AccessTokenBean(expires_in,access_token,refresh_token,openid,scope);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接 ,释放资源
            client.getConnectionManager().shutdown();
        }
        return bean;
    }
    
    public static void printToken() throws Exception {
        System.out.println("=========1获取token=========");
        String accessToken = getToken(GET_TOKEN_URL, APP_ID, SECRET);// 获取token
        if (accessToken != null)
            System.out.println(accessToken);
    }
    
    public static void main(String[] args) throws Exception {
    	printToken();
	}
}