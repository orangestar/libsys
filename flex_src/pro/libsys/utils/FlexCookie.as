package pro.libsys.utils
{
	import flash.net.SharedObject;
	
	import mx.utils.ObjectUtil;

	public class FlexCookie
	{
		private var cookie : SharedObject;
		
		public function FlexCookie()
		{
		}

		public static function getCookie(obj : Object) : FlexCookie
		{
			var className : String = ObjectUtil.getClassInfo(obj).name;
			cookie = SharedObject.getLocal(className.substr(className.indexOf("::") + 2));
			return new FlexCookie();
		}
		
		public function put(name : String, value : Object) : void
		{
			cookie.data[name] = value;
		}
		
		public function getValue(name : String) : Object
		{
			return cookie.data[name];
		}
		
		public function save() : void
		{
			cookie.flush();
		}
		
		public function clear() : void
		{
			cookie.clear();
		}
		
	}
}