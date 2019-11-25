package com.example.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

 
public class HttpUtil {
	
	 /**
	   * 
	   * 创建sendHttpRequest方法，进行响应速度数据解析和处理
	   *
	   */
	public static void sendHttpRequest(final String address,
			final HttpCallbackListener listener) {
		new Thread(new Runnable() {
			public void run() {
				HttpURLConnection connection = null;
				try {
					URL url = new URL(address);
					connection = (HttpURLConnection) url.openConnection();
					connection.setRequestMethod("GET");
					connection.setConnectTimeout(8000);
					connection.setReadTimeout(8000);
					InputStream in = connection.getInputStream();
					BufferedReader reader = new BufferedReader(new InputStreamReader(in));
					StringBuilder response = new StringBuilder();
					String line;
					while ((line = reader.readLine()) != null) {
						response.append(line);
					}
					if (listener != null) {
						// »Øµ÷onFinish()·½·¨
						listener.onFinish(response.toString());
					}
				} //语句测试代码块错误
				catch (Exception e) {
					if (listener != null) {
						// »Øµ÷onError()·½·¨
						listener.onError(e);
					}//处理语句代码块错误，即onError
				} finally {
					if (connection != null) {
						connection.disconnect();
					}
					
				}
			}
		}).start();
		/**
		 * 使用trycatch语句对try中定义的数据进行异常处理
		 */
	}
   
}