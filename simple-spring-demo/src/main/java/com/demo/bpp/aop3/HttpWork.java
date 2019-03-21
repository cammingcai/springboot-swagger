package com.demo.bpp.aop3;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.demo.bpp.aop3.execption.HttpCommonExecption;

/**
 * @author junhong
 */

@Service("work")
public class HttpWork {

    public void httpGet(String url) {
        String content = HttpClientUtil.doGet(url);
        System.out.println("url: " + url + ", content: " + content);
    }

    public void httpPost(String url, Map<String, Object> data) {
        String content = HttpClientUtil.doPost(url, data);
        System.out.println("url: " + url + ", content: " + content);
        throw new HttpCommonExecption("我也不知道什么错误原因了");
    }


}
