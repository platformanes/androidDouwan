package com.douwan.ane;

import android.util.Log;
import cn.douwan.sdk.DouwanSDKManager;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class DouwanExit implements FREFunction {

	private DouwanSDKManager mDouwanSDKManager;
	private String TAG = "DouWanExit";
	private FREContext _context;
	
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		// TODO Auto-generated method stub
		FREObject result = null;
		_context = context;
		try{

			result = FREObject.newObject("Exitcallback");
			//call back string
		}catch (Exception e) { 
			// TODO: handle exception
		}
		
		try{ 
	    	   //在这里调用JAR 执行登录
	    	   Log.d(TAG, "---------在这里调用JAR 执行回收资源-------");
	    	   mDouwanSDKManager = DouwanSDKManager.getInstance(_context.getActivity());
	    	   Log.d(TAG, "---------recycle-------");
	    	   mDouwanSDKManager.recycle();
	    	   Log.d(TAG, "---------exit-------");
	       }
		catch (Exception e) {    
	    	   _context.dispatchStatusEventAsync(TAG, "ExitError");
	       }
	       
		return result;
	}

}
