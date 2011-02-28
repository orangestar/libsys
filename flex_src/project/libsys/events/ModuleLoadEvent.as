package project.libsys.events
{
	import flash.events.Event;
	
	import mx.modules.IModuleInfo;
	
	public class ModuleLoadEvent extends Event
	{
		public static const LOAD_SUCCESS : String = "loadSuccess";
		
		public static const LOAD_FAILED : String = "loadFailed";
		
		public var message : String;
		
		public var module : IModuleInfo;
		
		public function ModuleLoadEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
	}
}