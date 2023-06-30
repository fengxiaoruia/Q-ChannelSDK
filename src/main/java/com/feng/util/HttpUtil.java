package com.feng.util;

import com.feng.config.ChannelBotClient;
import com.feng.config.HttpDeleteWithBody;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

@Slf4j
public class HttpUtil {

    private static HttpClient createHttpClient(){
        HttpClient httpClient = HttpClientBuilder.create().build();
        return httpClient;
    }
    public static HttpResponse post(String url, String data){
        HttpClient httpClient = createHttpClient();
        HttpPost httpPost = new HttpPost(url); // 替换为实际的事件流URL
        httpPost.setHeader("Authorization", ChannelBotClient.BOT_OPEN_KEY);
        httpPost.setHeader("Content-Type", "application/json");
        StringEntity entity = new StringEntity(data, "utf-8");//解决中文乱码问题
        httpPost.setEntity(entity);
        try {
            HttpResponse execute = httpClient.execute(httpPost);
            return execute;
        } catch (IOException e) {
            log.error("post请求失败,原因:{ }",e);
            return null;
        }
    }


    public static HttpResponse patch(String url, String data){
        HttpClient httpClient = createHttpClient();
        HttpPatch httpPatch = new HttpPatch(url); // 替换为实际的事件流URL
        httpPatch.setHeader("Authorization", ChannelBotClient.BOT_OPEN_KEY);
        httpPatch.setHeader("Content-Type", "application/json");
        StringEntity entity = new StringEntity(data, "utf-8");//解决中文乱码问题
        httpPatch.setEntity(entity);
        try {
            HttpResponse execute = httpClient.execute(httpPatch);
            return execute;
        } catch (IOException e) {
            log.error("patch请求失败,原因:{ }",e);
            return null;
        }
    }
    public static HttpResponse get(String url){
        HttpClient httpClient = createHttpClient();
        HttpGet httpGet = new HttpGet(url); // 替换为实际的事件流URL
        httpGet.setHeader("Authorization", ChannelBotClient.BOT_OPEN_KEY);
        httpGet.setHeader("Content-Type", "application/json");
        try {
            HttpResponse execute = httpClient.execute(httpGet);
            return execute;
        } catch (IOException e) {
            log.error("get请求失败,原因:{}",e.getMessage());
            return null;
        }
    }


    public static HttpResponse put(String url){
        HttpClient httpClient = createHttpClient();
        HttpPut httpPut = new HttpPut(url); // 替换为实际的事件流URL
        httpPut.setHeader("Authorization", ChannelBotClient.BOT_OPEN_KEY);
        httpPut.setHeader("Content-Type", "application/json");
        try {
            HttpResponse execute = httpClient.execute(httpPut);
            return execute;
        } catch (IOException e) {
            log.error("put请求失败,原因:{}",e.getMessage());
            return null;
        }
    }


    public static HttpResponse put(String url,String data){
        HttpClient httpClient = createHttpClient();
        HttpPut httpPut = new HttpPut(url); // 替换为实际的事件流URL
        httpPut.setHeader("Authorization", ChannelBotClient.BOT_OPEN_KEY);
        httpPut.setHeader("Content-Type", "application/json");
        StringEntity entity = new StringEntity(data, "utf-8");//解决中文乱码问题
        httpPut.setEntity(entity);
        try {
            HttpResponse execute = httpClient.execute(httpPut);
            return execute;
        } catch (IOException e) {
            log.error("put请求失败,原因:{}",e.getMessage());
            return null;
        }
    }

    public static HttpResponse delete(String url){
        HttpClient httpClient = createHttpClient();
        HttpDelete httpDelete = new HttpDelete(url); // 替换为实际的事件流URL
        httpDelete.setHeader("Authorization", ChannelBotClient.BOT_OPEN_KEY);
        httpDelete.setHeader("Content-Type", "application/json");
        try {
            HttpResponse execute = httpClient.execute(httpDelete);
            return execute;
        } catch (IOException e) {
            log.error("delete请求失败,原因:{}",e.getMessage());
            return null;
        }
    }

    public static HttpResponse delete(String url,String data){
        HttpClient httpClient = createHttpClient();
        HttpDeleteWithBody httpDelete = new HttpDeleteWithBody(url); // 替换为实际的事件流URL
        httpDelete.setHeader("Authorization", ChannelBotClient.BOT_OPEN_KEY);
        httpDelete.setHeader("Content-Type", "application/json");
        StringEntity requestEntity = new StringEntity(data, ContentType.APPLICATION_JSON);
        httpDelete.setEntity(requestEntity);
        try {
            HttpResponse execute = httpClient.execute(httpDelete);
            return execute;
        } catch (IOException e) {
            log.error("delete请求失败,原因:{}",e.getMessage());
            return null;
        }
    }
    public static String getHttpResponseString(HttpResponse httpResponse){
        if(httpResponse!=null) {
            HttpEntity entity = httpResponse.getEntity();
            try {
                String httpResult = EntityUtils.toString(entity);
                return httpResult;
            } catch (IOException e) {
                log.error("解析请求体异常,{}", e.getMessage());
                return "";
            }
        }else {
            log.error("请求结果为null");
            return "";
        }
    }
}
