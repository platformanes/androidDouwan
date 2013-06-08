package com.douwan.ane;


import com.adobe.fre.FREContext;

import cn.douwan.sdk.DouwanSDKManager;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BridgePayActivity extends Activity implements
OnClickListener {
	//声明开启Activity的Action
	public static final String MYACTIVITY_ACTION = "com.douwan.ane.BridgePayActivity";
	private String TAG = "BridgePayActivity";
	public static String gameServerID ;
	public static String serverName ;
	public static String roleId ;
	public static String gameRole ;
	public static String callBackInfo ;
	public static Activity callBackActivity ;
	public static FREContext _context;
	private DouwanSDKManager mDouwanSDKManager;
	private LinearLayout layout;
	private static Boolean isExit = false;

	protected static final int UPDATE_TEXT = 0;
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case 1:
			Log.d(TAG, "---------退出-------");
			isExit = false;
			BridgePayActivity.this.finish();
			break;
		case 3:
			mDouwanSDKManager.showPaymentView(gameServerID, serverName, roleId,
					gameRole, callBackInfo);
			break;
		}
	}
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//构建界面

		super.onCreate(savedInstanceState);
		Log.d(TAG, "---------getResourceId-------");
		//		this.setContentView( _context.getResourceId("layout.bridge"));
		Log.d(TAG, "---------在这里调用JAR 执行付费-------");
		mDouwanSDKManager = DouwanSDKManager.getInstance(this);
		if(!isExit)mDouwanSDKManager.showPaymentView(gameServerID, serverName, roleId,
				gameRole, callBackInfo);
		Log.d(TAG, "---------getResourceId--2-----");
		// 隐藏标题栏  
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);  
		// 隐藏状态栏  
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,  
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		layout.setBackgroundResource(_context.getResourceId("drawable.bg"));
		this.setContentView(layout);
		
		//添加事件侦听
		//			submitReturn = new Button(this);
		//			submitReturn.setText("返回");
		//			submitReturn.setId(1);
		//			layout.addView(submitReturn);

		TextView textv = new TextView(this);
		String str_2 = "跳转支付验证！点击任意返回游戏....";
		textv.setText(str_2);
		layout.addView(textv);
		
		layout.setId(1);
		layout.setOnClickListener(this);

		
		isExit = true;

	}

	@Override  
	public boolean onKeyDown(int keyCode, KeyEvent event)  
	{  
		if (keyCode == KeyEvent.KEYCODE_BACK )  
		{  
			isExit = false;
		}  
		return super.onKeyDown(keyCode, event);

	}  

}
