package com.douwan.ane;
/**
 * 映射
 * @author Rect 2013-3-14
 */
import java.util.HashMap;
import java.util.Map;


import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;

public class DouwanContext extends FREContext {

	/**
	 * 登录Key
	 */
	public static final String DOUWAN_FUNCTION_LOGIN = "douwan_function_login";
	/**
	 * 付费Key
	 */
	public static final String DOUWAN_FUNCTION_PAY = "douwan_function_pay";
	/**
	 * 退出Key
	 */
	public static final String DOUWAN_FUNCTION_EXIT = "douwan_function_exit";
	
	public static final String START_ACTIVITY_FUNCTION = "start_activity_function";
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<String, FREFunction> getFunctions() {
		// TODO Auto-generated method stub
		Map<String, FREFunction> map = new HashMap<String, FREFunction>();
	       //映射
	       map.put(DOUWAN_FUNCTION_LOGIN, new DouwanLogin());
	       map.put(DOUWAN_FUNCTION_PAY, new DouwanPay());
	       map.put(DOUWAN_FUNCTION_EXIT, new DouwanExit());
	       return map;
	}

}
