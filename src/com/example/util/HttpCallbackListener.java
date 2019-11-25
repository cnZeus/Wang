package com.example.util;


  /**
   * 
   * 定义接口类HttpCallbackListener，其中包含onFinish，onError两个常量
   *
   */
public interface HttpCallbackListener {

	void onFinish(String response);

	void onError(Exception e);

}