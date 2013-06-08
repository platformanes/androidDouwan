package com.douwan.ane 
{ 
	import flash.events.EventDispatcher;
	import flash.events.StatusEvent;
	import flash.external.ExtensionContext;

	/**
	 * 
	 * @author Rect  2013-3-15 
	 * 
	 */
	public class DouwanExtension extends EventDispatcher
	{ 
		public static const DOUWAN_FUNCTION_LOGIN:String = "douwan_function_login";//与java端中Map里的key一致
		public static const DOUWAN_FUNCTION_PAY:String = "douwan_function_pay";//与java端中Map里的key一致
		public static const DOUWAN_FUNCTION_EXIT:String = "douwan_function_exit";//与java端中Map里的key一致
		
		public static const EXTENSION_ID:String = "com.douwan.ane";//与extension.xml中的id标签一致
		private var extContext:ExtensionContext;
		
		/**单例的实例*/
		private static var _instance:DouwanExtension;   
		
		
		
		
		/**
		 * 获取实例
		 * @return DouwanExtension 单例
		 */
		public static function getInstance():DouwanExtension
		{
			if(_instance == null) 
				_instance = new DouwanExtension();
			return _instance;
		}
		
		/**
		 * 转抛事件
		 * @param event 事件
		 */
		private function statusHandler(event:StatusEvent):void
		{
			dispatchEvent(event);
		}
		
		public function DouwanExtension()
		{
			if(extContext == null) {
				extContext = ExtensionContext.createExtensionContext(EXTENSION_ID, "");
				extContext.addEventListener(StatusEvent.STATUS, statusHandler);
			}
			//第二个为参数，会传入java代码中的FREExtension的createContext方法
		} 
		
		/**
		 *登录发送函数  
		 * @param key 暂时传什么都可以  留着可能要用
		 * @return 
		 * 
		 */		
		public function LogInDouwan(key:int):String{
			if(extContext ){
				return extContext.call(DOUWAN_FUNCTION_LOGIN,key) as String;
			}
			return "call login failed";
		} 
		/**
		 *付费发送函数 
		 * @param data 
		 * @return 
		 * 
		 */		 
		public function PayDouwan(data:Vector.<String>):String{
			if(extContext && data.length == 5){ 
				return extContext.call(DOUWAN_FUNCTION_PAY,data)as String;
			}
			return "call pay failed";
		}
		
		/**
		 *退出SDK时候调用   这个函数只在退出游戏的时候调用  
		 * @param key
		 * @return 
		 * 
		 */		
		public function ExitSDKHandle(key:int):String{
			if(extContext){ 
				return extContext.call(DOUWAN_FUNCTION_EXIT,key) as String;
			}
			return "call exit failed";
		}
		/**
		 *获取用户名 暂时没实现 看需要  
		 * @return 
		 * 
		 */		
		public function getUserName():String{
			return null;
		}
		
		/**
		 *获取唯一ID标识 暂时没实现 看需要  
		 * @return 
		 * 
		 */
		public function getUserID():String{
			return null;
		}
	} 
}