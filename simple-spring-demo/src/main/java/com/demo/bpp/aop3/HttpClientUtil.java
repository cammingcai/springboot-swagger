package com.demo.bpp.aop3;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.demo.bpp.aop3.execption.HttpCodeExecption;
import com.demo.bpp.aop3.execption.HttpCommonExecption;
import com.demo.bpp.aop3.execption.HttpConnectExecption;
import com.demo.bpp.aop3.execption.HttpConnectTimeOutExecption;
import com.demo.bpp.aop3.execption.HttpSocketTimeOutExecption;

/**
 * Created by junhong
 */
public class HttpClientUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    private static final int TIME = 2;

    private static final int REPEAT_TIME = 2;

    private static final RequestConfig REQUEST_CONFIG = RequestConfig.custom()
            // socket超时为2秒
            .setSocketTimeout(TIME * 1000)
            // connection连接超时为2秒
            .setConnectTimeout(TIME * 1000)
            // 请求超时为2秒
            .setConnectionRequestTimeout(TIME * 1000).build();

    public static String doGet(String url){
        HttpGet httpGet = new HttpGet(url);

        httpGet.setConfig(REQUEST_CONFIG);

        return execute(httpGet);
    }

    public static String doPost(String url, Map<String, Object> data){
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(REQUEST_CONFIG);

        String jsonStr = JSON.toJSONString(data);

        setPostJsonEntity(httpPost, jsonStr);

        return execute(httpPost);
    }

    public static String doPostWithFrom(String url, Map<String, String> data) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(REQUEST_CONFIG);

        setPostFormEntity(httpPost, data, Charset.forName("utf-8"));

        return execute(httpPost);
    }

    public static String doPatch(String url) {
        HttpPatch httpPatch = new HttpPatch(url);
        httpPatch.setConfig(REQUEST_CONFIG);

        return execute(httpPatch);
    }

    public static String doDelete(String url) {
        HttpDelete httpDelete = new HttpDelete(url);
        httpDelete.setConfig(REQUEST_CONFIG);

        return execute(httpDelete);
    }

    public static String doPut(String url, Map<String, String> data) {
        HttpPut httpPut = new HttpPut(url);
        httpPut.setConfig(REQUEST_CONFIG);

        String jsonStr = JSON.toJSONString(data);

        setPutJsonEntity(httpPut, jsonStr);

        return execute(httpPut);
    }


    private static void setPostEntity(HttpPost httpPost, String entity, String contentType) {
        StringEntity stringEntity = new StringEntity(entity, "UTF-8");
        httpPost.setEntity(stringEntity);
        httpPost.setHeader("Content-Type", contentType);
    }

    private static void setPostJsonEntity(HttpPost httpPost, String jsonStr) {
        StringEntity stringEntity = new StringEntity(jsonStr, "UTF-8");
        httpPost.setEntity(stringEntity);
        httpPost.setHeader("Content-Type", "application/json; charset=utf-8");
    }

    private static void setPutJsonEntity(HttpPut httpPut, String jsonStr){
        StringEntity stringEntity = new StringEntity(jsonStr, "UTF-8");
        httpPut.setEntity(stringEntity);
        httpPut.setHeader("Content-Type", "application/json; charset=utf-8");
    }

    private static void setPostFormEntity(HttpPost httpPost, Map<String, String> data, Charset encodeCharset){
        List<NameValuePair> pairs = data.entrySet().stream().map(entry ->
                new BasicNameValuePair(entry.getKey(), entry.getValue())).collect(Collectors.toList());
        StringEntity stringEntity = new UrlEncodedFormEntity(pairs, encodeCharset);
        httpPost.setEntity(stringEntity);
    }

    private static String execute(HttpRequestBase request){
        String url = null;
        CloseableHttpClient httpclient = null;
        try {
            url = request.getURI().toString();
            httpclient = HttpClientBuilder.create().
                    setRetryHandler(new DefaultHttpRequestRetryHandler(REPEAT_TIME, true)).build();

            CloseableHttpResponse response = httpclient.execute(request);

            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode != 200) {
                throw new HttpCodeExecption("HTTPCode:" + statusCode);
            }

            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity, "UTF-8");
        } catch (ConnectTimeoutException e) {
            throw new HttpConnectTimeOutExecption();
        } catch (SocketTimeoutException e) {
            throw new HttpSocketTimeOutExecption();
        } catch (ConnectException e){
            throw new HttpConnectExecption();
        } catch (Exception e) {
            if (e instanceof HttpCodeExecption) {
                throw (HttpCodeExecption) e;
            }
            throw new HttpCommonExecption(e.getMessage());
        } finally {
            if(httpclient != null){
                try {
                    httpclient.close();
                } catch (IOException e) {
                    logger.error("httpclient error:{}", e);
                }
            }
        }
    }

}
