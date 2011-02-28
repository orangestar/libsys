package project.libsys.utils
{
	import flash.events.EventDispatcher;
	import flash.system.ApplicationDomain;
	
	import mx.events.ModuleEvent;
	import mx.managers.CursorManager;
	import mx.modules.IModuleInfo;
	import mx.modules.ModuleManager;
	
	import project.libsys.events.ModuleLoadEvent;
	
	[Event(name="loadSuccess", type="project.libsys.ModuleLoadEvent")]
	
	[Event(name="loadFailed", type="project.libsys.ModuleLoadEvent")]

	public class ModuleFactory extends EventDispatcher
	{
		private var moduleInfo : IModuleInfo;
		
		private static var _instance : ModuleFactory;
		
		public static function get instance() : ModuleFactory
		{
			if(_instance == null) {
				_instance = new ModuleFactory(new HiddenClass());
			}
			return _instance;
		}
		
		public function load(moduleUrl : String) : void
		{
			if(moduleUrl == null) {
				return;
			}
			moduleInfo = ModuleManager.getModule(moduleUrl);
			moduleInfo.addEventListener(ModuleEvent.READY, onModuleReady);
			moduleInfo.addEventListener(ModuleEvent.ERROR, onModuleError, false, 0, true);
			CursorManager.getInstance().setBusyCursor();
			moduleInfo.load(ApplicationDomain.currentDomain);
		}
		
		private function onModuleReady(event : ModuleEvent) : void
		{
			CursorManager.getInstance().removeBusyCursor();
			var e : ModuleLoadEvent = new ModuleLoadEvent(ModuleLoadEvent.LOAD_SUCCESS);
			e.module = event.module;
			dispatchEvent(e);
		}
		
		// Fired when module loaded error
		private function onModuleError(event : ModuleEvent) : void
		{
			CursorManager.getInstance().removeBusyCursor();
			if(moduleInfo != null) {
				moduleInfo.unload();
			}
			var e : ModuleLoadEvent = new ModuleLoadEvent(ModuleLoadEvent.LOAD_FAILED);
			e.message = event.errorText;
			e.module = event.module;
			dispatchEvent(e);
		}
		
		public function ModuleFactory(hidden : HiddenClass)
		{
		}
	}
}

class HiddenClass {
	
}