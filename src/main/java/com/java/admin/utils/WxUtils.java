package com.java.admin.utils;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.Map;

public class WxUtils {
    public static final String APPID = "123456";
    public static final String SECRET = "123456";

    public static Map<String, Object> getOpenIdByCode(String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + APPID + "&secret=" + SECRET + "&js_code=" + code + "&grant_type=authorization_code";
        String resultStr = "";
        try {
            resultStr = HttpClientHelper.sendGet(url);
        } catch (IOException e) {
            throw new CustomException("微信通过code获取openId IO错误");
        }
        JSONObject object = JSONObject.parseObject(resultStr);
        Integer errcode = (Integer) object.get("errcode");
        if (errcode != 0) {
            throw new CustomException("微信code错误");
        }
        return object;
    }
}
