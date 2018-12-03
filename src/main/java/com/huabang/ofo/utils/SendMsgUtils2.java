package com.huabang.ofo.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.aliyuncs.exceptions.ClientException;

public class SendMsgUtils2 {

	public static void main(String[] args) {
		try {
			sendSms("17631386093", "123465");
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Boolean sendSms(String telephone, String checkcode) throws ClientException {
//					  http://sms.hnykxx.com/sms.aspx
		String url = "http://47.105.60.51:8088/smsGBK.aspx";
		/**
		 * action=send&userid=12&account=账号&password=密码&mobile=15023239810,
		 * 13527576163&content=内容&sendTime=&extno=
		 */
		String parms = "action=send&userid=320&account=doushihy&password=123456&mobile="+telephone+"&content=尊敬的用户：您正在使用手机注册登陆，验证码为：" + checkcode+"&sendTime=&extno=";
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("action", "send"));
		nvps.add(new BasicNameValuePair("userid", "320"));
		nvps.add(new BasicNameValuePair("account", "doushihy"));// "+checkcode+"
		nvps.add(new BasicNameValuePair("password", "123456"));// "+checkcode+"
		nvps.add(new BasicNameValuePair("mobile", telephone));// "+checkcode+"您的验证码是：123457 请在5分钟内使用，注意使用安全
		nvps.add(new BasicNameValuePair("content", "【奇趣智玩】您的验证码是：" + checkcode + "请在5分钟内使用，注意使用安全。"));
		nvps.add(new BasicNameValuePair("sendTime", ""));
		nvps.add(new BasicNameValuePair("extno", ""));
//		String post = sendPost(url, parms); // post请求
		String post = httpPost(url, nvps); // post请求
		System.err.println("返回内容为：：" + post);
		Boolean concat = post.contains("ok");
		// String getparam =
		// "userCode=用户名&userPass=密码&DesNo=手机号&Msg=短信内容【签名】&Channel=0";
		// String result = httpGet(url, getparam); // get请求
		return concat;
	}

	public static String httpPost(String url, List<NameValuePair> params) {
		String result = "";
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(url);
			httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
			HttpResponse response = httpclient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream instreams = entity.getContent();
				result = convertStreamToString(instreams);
				System.out.println(result);
			}
		} catch (Exception e) {
		}
		return result;
	}

	public static String httpGet(String url, String params) {
		String result = "";
		try {
			HttpClient client = new DefaultHttpClient();
			if (params != "") {
				url = url + "?" + params;
			}
			HttpGet httpget = new HttpGet(url);
			HttpResponse response = client.execute(httpget);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream instreams = entity.getContent();
				result = convertStreamToString(instreams);
				System.out.println(result);
			}
		} catch (Exception e) {
		}
		return result;
	}

	public static String convertStreamToString(InputStream is) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

	/**
	 * 向指定 URL 发送POST方法的请求
	 * 
	 * @param url
	 *            发送请求的 URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

}
