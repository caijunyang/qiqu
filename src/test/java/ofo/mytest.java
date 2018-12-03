package ofo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import org.aspectj.weaver.ast.Test;

public class mytest {

	public static void main(String[] args) throws Exception{
		//String urlStr = "http://localhost:80/user/send?telephone=425144174493800";
		//System.out.println(getURLContent(urlStr));
	}
	
	public static String getURLContent() throws Exception {
		String strURL = "http://www.anjismart.com:7770/QueryCodeService.asmx/QueryCode?code=425144174493800&aid=302";
        URL url = new URL(strURL);
        HttpURLConnection httpConn = (HttpURLConnection)url.openConnection();
        httpConn.setRequestMethod("GET");
        httpConn.connect();
            
        BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
        String line;
        StringBuffer buffer = new StringBuffer();
        while ((line = reader.readLine()) != null) {
        	buffer.append(line);
        }
        reader.close();
        httpConn.disconnect();
         
       System.out.println(buffer.toString());
       return buffer.toString();
	}
	
	/**
	 * 程序中访问http数据接口
	 */
	public static String getURLContent(String urlStr) {
		/** 网络的url地址 */
		URL url = null;
		/** http连接 */
		HttpURLConnection httpConn = null;
		/**//** 输入流 */
		BufferedReader in = null;
		StringBuffer sb = new StringBuffer();
		try {
			url = new URL(urlStr);
			in = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			String str = null;
			while ((str = in.readLine()) != null) {
				sb.append(str);
			}
		} catch (Exception ex) {
 
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
			}
		}
		String result = sb.toString();
		System.out.println(result);
		return result;
	}

}
