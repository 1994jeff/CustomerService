package com.example.customerservicesystem.untils;

public class GetOpenIdByCodeAndAccessToken {

    //高级接口获取用户信息链接
    public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+AccessTokenUtil.APP_ID+"&secret="+AccessTokenUtil.SECRET+"&code=CODE&grant_type=authorization_code";
    
}
