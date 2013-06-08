package com.douwan.ane 
{ 
	/**
	 * 
	 * @author Rect  2013-4-22 
	 * 
	 */
	public class DouwanEvents 
	{ 
		public function DouwanEvents()
		{
		} 
		/**************************平台通知************************************/
		/**
		 * 用户登录
		 */
		public static const DOUWAN_LOGIN_STATUS : String = "DouWanLogIn";
		
		/**
		 * 用户注销
		 */
		public static const DOUWAN_LOGOUT_STATUS : String = "DouWanExit";
		
		/**
		 * 充值
		 */
		public static const DOUWAN_PAY_STATUS : String = "DouWanPay";
	} 
}