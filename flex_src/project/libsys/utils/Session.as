package project.libsys.utils
{
	public dynamic class Session
	{
		private static var _instance : Session;
		
		public static function get instance() : Session
		{
			if(_instance == null) {
				_instance = new Session(new HiddenClass());
			}
			return _instance;
		}
		
		public function Session(hidden : HiddenClass)
		{
		}
	}
}

class HiddenClass {
	
}