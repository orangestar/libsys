package project.libsys.utils
{
	import mx.utils.ArrayUtil;

	public class AppContext
	{
		private static var _instance : AppContext;
		
		public static function get instance() : AppContext
		{
			if(_instance == null) {
				_instance = new AppContext(new HiddenClass());
			}
			return _instance;
		}
		
		private var moduleList : Array = [];
		
		public function getModuleIndex(id : String) : int
		{
			var idx : int = ArrayUtil.getItemIndex(id, moduleList);
			if(idx < 0) {
				moduleList.push(id);
			}
			return idx;
		}
		
		public function removeModuleIndex(id : String) : void
		{
			var idx : int = ArrayUtil.getItemIndex(id, moduleList);
			if(idx >= 0) {
				moduleList.splice(idx, 1);
			}
		}
		
		public function AppContext(hidden : HiddenClass)
		{
		}
	}
}

class HiddenClass {
	
}