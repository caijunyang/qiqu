package com.huabang.ofo.utils.alipay.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.3
 *日期：2012-08-10
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
	
 *提示：如何获取安全校验码和合作身份者ID
 *1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 *2.点击“商家服务”(https://b.alipay.com/order/myOrder.htm)
 *3.点击“查询合作者身份(PID)”、“查询安全校验码(Key)”

 *安全校验码查看时，输入支付密码后，页面呈灰色的现象，怎么办？
 *解决方法：
 *1、检查浏览器配置，不让浏览器做弹框屏蔽设置
 *2、更换浏览器或电脑，重新登录查询。
 */

public class AlipayConfig {
	
	//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	// 合作身份者ID，以2088开头由16位纯数字组成的字符串
	public static String partner = "2088722090993270";
	// 商户的私钥
	public static String private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDG93vdSnYBF9mNLiSvemmf/y4meDu0+HbPAdyoy1CyNjDqkHngaWB3ma7K7jp9Ij88kSymCbfEezakK9dIDsIoNSkSwuHFOaH60HJU4tROYXmNYMJP9K5Gs4PNXAK06l9j2eH43RYUm3RkInO7k6ELZfuBwtNm6163dYQ6appFzYyJOFCOHsAGNWH2BXCUrMSOCfDr/CUvXt6vv4Vauui5pIGRXzIPPxXmoymfTFuEg2MlU0L78DLqaFPXFSpPLzd4fav/WFKshATodJaR+ZX3G4eX75/HjqUOYsIjXwTtNrLgT4CvJyez3xhpl/2+GiRsV6uVVumdDSW3eQcL5sztAgMBAAECggEAWKig3hu294e8HkfoevUOKghYdTXwTRTGRDntLJ3kaHTzWSJl3JS4MrMdizmagHYJPaDnB1mfNIM+9uq+NFK3O5lsovqKBgtHXW8S8zZcKk0PD+uEyoIaQlDts02Du0AQn3rQUceadjZLJ++eKICBK4YXC1xYPS02eIN6F1m3QtCqfSI70L/m8/LrE1y+DK/TJxr2ciLW0m5uYa+tKwvh3QIgpDQEWTDJ2cU0G9Jg3Tp3ERm2/g8NZrfnShUbFp+h7rW/a1FdVs5AWt/eTnxQl/bs0BQg1jb9zTIJMjzPYUm2nRxkAWrib1V/8R4nXM0V072mPiHmWbz+tuMRu9ZsdQKBgQDwXGGeY0712NlgxfPmTIcHq5ZuTqBoD/1seJlX0BOYNlKdOw+rIu7HXchkG40oCc9tm3yWkvOI/UN4c1QoEv0C8yXndnUK9o4aFBO7k9USsln2V9+rcIySOM49a4k+GYr91trGuxiFVnQ4sZyWrLzXzbeY2ZXmZVdhA9NAJ/Gi1wKBgQDT6Zzo0ySmPukWh/OVFjmRhMh58+ndq1BK0+f92NbNStbVtBPBDNOQJRXx0aOmz6mNEP+DteSEfyANk4+7d8GbXzip/XIGBiPcEy+13Vw67WDuNQ1uNrKC3W+k7nvP8V6wIR/uAAYmWyOKbTtLnwXOkBhxPDaCwrRIbI4ue1KZ2wKBgAwLVQjuyQIgv6PNx47+vrVvr7YPUpJkWrqYwHZaAuFZt4IRd5OHyJdM58G8b7JV64L+i5uv+Wwf5MWgYdMwQGVpcbjLgsnt2OkNoH+BxOeO8FsbxCV/GkwpdIw3W0U1WnWl0oiqz2u/DUvZ+pLCTSQzNsP+AzjsUxiVbHyGg+E5AoGAPl7e0OP8QHX5sqj292VgMkVLoCE7LwQSEMQH3v3oUun5C1MCEWrOBfn0WIUkTp+GPr/HBKQPizPDYluRDVM1B57iFZ5D5iP+f/KhszxgvfNJ+TJiLpMovT2hc4DBrjVTcjF9rVYSeU2Py1lU/2/hjKd6mjFntdrKpxpUSrf/WssCgYEAswAaHFGkJxzjTQD6FCOZ2m8OzCQT7/RZv+Y/QZrQXTxUgxXduQjsXFoCQbzn1gLdsHZT7/BJIvjMVGHXQtmkZt5nAp2Wh9+uEIXA3NLaxLa9yMN7e36Cww7oG1HEAfxAgupAMzmz240ePqJi/QwfJqoPfQ5uNleeg58fydp2F/A="; 
	//支付宝收款人账号
	public static String seller_email = "2088102175759801";		 


	
	// 支付宝的公钥，无需修改该值 。   开放平台首页-》PID和公钥管理-》合作伙伴密钥-》RSA(SHA1)密钥: 查看开发者公钥 |查看支付宝公钥
	public static String ali_public_key  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";

	//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	

	// 调试用，创建TXT日志文件夹路径
	public static String log_path = "D:\\LOG\\";

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";
	
	// 签名方式 不需修改
	public static String sign_type = "RSA";

}
