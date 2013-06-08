package com.douwan.ane;
/**
 * 登录接口
 * @author Rect 2013-3-14
 */


import android.os.Handler;
import android.util.Log;
import cn.douwan.sdk.DouwanSDKManager;
import cn.douwan.sdk.LoginCallbackInfo;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class DouwanLogin implements FREFunction {
	
	private DouwanSDKManager mDouwanSDKManager;
	private String TAG = "DouWanLogIn";
	private FREContext _context;
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		// TODO Auto-generated method stub
		
		_context = context;
		
		 FREObject result = null; 
	       try{
	    	   Log.d(TAG, "---------第一个 try-------");
	           result = FREObject.newObject("callBack ");//+arg1[0].getAsString()
	           
	       }catch (Exception e) { 
	           // TODO: handle exception
	       }
	       
	       try{ 
	    	   //在这里调用JAR 执行登录
	    	   Log.d(TAG, "---------在这里调用JAR 执行登录-------");
	    	   mDouwanSDKManager = DouwanSDKManager.getInstance(context.getActivity());
	    	   Log.d(TAG, "---------One-------");
	    	   mDouwanSDKManager.showLoginView(mHandler, 
						DouwanSDKManager.WHAT_LOGIN_CALLBACK_DEFAULT);
	    	   Log.d(TAG, "---------two-------");
	       }catch (Exception e) {    
	    	   _context.dispatchStatusEventAsync(TAG, "LogInError");
	       }
	      
	       return result;   
	}
	private Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case DouwanSDKManager.WHAT_LOGIN_CALLBACK_DEFAULT: 
				LoginCallbackInfo info = (LoginCallbackInfo) msg.obj;
				Log.d(TAG, "info----- : " + info.toString()); 
				Log.d(TAG, "---------用户登录-------");
				String str = "返回数据";
				str += "*"+info.statusCode;
				str += "*"+info.userId;
				str += "*"+info.userName;
				str += "*"+info.desc;
				str += "*"+info.timestamp;
				str += "*"+info.sign;
				_context.dispatchStatusEventAsync(TAG, str);
				break;
			}
		}
	};
}
