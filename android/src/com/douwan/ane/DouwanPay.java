package com.douwan.ane;
/**
 * 付费
 * @author Rect 2013-3-15
 */

import android.content.Intent;
import android.util.Log;

import com.adobe.fre.FREArray;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class DouwanPay implements FREFunction {

	private String TAG = "DouWanPay";
	private FREContext _context;
	@Override
	public FREObject call(final FREContext context, FREObject[] $args) {
		// TODO Auto-generated method stub
		FREObject result = null;
		_context = context;
		String gameServerID = null;
		String serverName = null;
		String roleId = null;
		String gameRole = null;
		String callBackInfo = null;

		if($args.length<1)
		{
			_context.dispatchStatusEventAsync(TAG,"参数不正确！");
			return null;
		}

		
		try{
			FREArray __array = (FREArray) $args[0];
			int __len = (int)__array.getLength();
			if(__len != 5)
			{
				_context.dispatchStatusEventAsync(TAG,"传入数组参数不正确！");
				return null;
			}

			gameServerID = __array.getObjectAt(0).getAsString();
			serverName = __array.getObjectAt(1).getAsString();
			roleId = __array.getObjectAt(2).getAsString(); 
			gameRole = __array.getObjectAt(3).getAsString();
			callBackInfo = __array.getObjectAt(4).getAsString(); 

			//call back string
		}catch (Exception e) { 
			// TODO: handle exception
			_context.dispatchStatusEventAsync(TAG, "PayError:"+e.getMessage());
		}

		try{ 
			BridgePayActivity.gameServerID = gameServerID;
			BridgePayActivity.serverName = serverName;
			BridgePayActivity.roleId = roleId;
			BridgePayActivity.gameRole = gameRole;
			BridgePayActivity.callBackInfo = callBackInfo;
			BridgePayActivity.callBackActivity = _context.getActivity();
			BridgePayActivity._context = _context;
			Log.d(TAG, "---------Intent处理-------");
			Intent intent = new Intent(BridgePayActivity.MYACTIVITY_ACTION);
			_context.getActivity().startActivityForResult(intent, 0); 
			Log.d(TAG, "---------start处理-------");
			//在这里调用JAR 执行登录
//			Log.d(TAG, "---------在这里调用JAR 执行付费-------");
//			mDouwanSDKManager = DouwanSDKManager.getInstance(context.getActivity());
//			Log.d(TAG, "---------One-------");
//			mDouwanSDKManager.showPaymentView(gameServerID, serverName, roleId,
//					gameRole, callBackInfo);
			
			 
			Log.d(TAG, "---------two-------");
			Log.d(TAG, "充值弹出 ：gameServerID : " + gameServerID);
			Log.d(TAG, "充值弹出 ：serverName : " + serverName);
			Log.d(TAG, "充值弹出 ：roleId : " + roleId);
			Log.d(TAG, "充值弹出 ：gameRole : " + gameRole); 
			Log.d(TAG, "充值弹出 ：callBackInfo : " + callBackInfo);
		}catch (Exception e) {    
			_context.dispatchStatusEventAsync(TAG, "PayError:"+e.getMessage());
		}

		return result;  

	}

}
