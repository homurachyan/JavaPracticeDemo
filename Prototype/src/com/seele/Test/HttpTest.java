package com.seele.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpTest {
	//查询余额的Http接口地址
	private static String URI_GET_USER_INFO = "http://sdk4rptws.eucp.b2m.cn:8080/sdkproxy/querybalance.action";

	//智能匹配模版发送接口的http地址
	private static String URI_SEND_SMS = "http://yunpian.com/v1/sms/send.json";
	
	private static String cdkey = "0SDK-EBB-6688-KFUQL";
	
	private static String password = "295191";
	
	//编码格式。发送编码格式统一用UTF-8
	private static String ENCODING = "UTF-8";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("cdkey", cdkey);
	    params.put("password", password);
	    post(URI_GET_USER_INFO, params);
	}
	/**
	* 基于HttpClient 4.3的通用POST方法
	*
	* @param url       提交的URL
	* @param paramsMap 提交<参数，值>Map
	* @return 提交响应
	*/

	public static String post(String url, Map<String, String> paramsMap) {
	    CloseableHttpClient client = HttpClients.createDefault();
	    String responseText = "";
	    CloseableHttpResponse response = null;
	    try {
	        HttpPost method = new HttpPost(url);
	        if (paramsMap != null) {
	            List<NameValuePair> paramList = new ArrayList<NameValuePair>();
	            for (Map.Entry<String, String> param : paramsMap.entrySet()) {
	                NameValuePair pair = new BasicNameValuePair(param.getKey(), param.getValue());
	                paramList.add(pair);
	            }
	            method.setEntity(new UrlEncodedFormEntity(paramList, ENCODING));
	        }
	        response = client.execute(method);
	        HttpEntity entity = response.getEntity();
	        if (entity != null) {
	            responseText = EntityUtils.toString(entity);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            response.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	        return responseText;
	    }
}
