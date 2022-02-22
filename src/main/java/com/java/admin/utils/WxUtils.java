package com.java.admin.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import sun.net.www.http.HttpClient;

import java.io.IOException;

public class WxUtils {
    public static final String APPID="123456";
    public static final String SECRET="123456";

    public static String getOpenIdByCode(String code){
        String  url= "https://api.weixin.qq.com/sns/jscode2session?appid="+APPID+"&secret="+SECRET+"&js_code="+code+"&grant_type=authorization_code";
        try {
            return HttpClientHelper.sendGet(url);
        } catch (IOException e) {
            throw new CustomException("微信通过code获取openId错误");
        }
    }
}
