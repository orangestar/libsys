package project.libsys.events
{
	import flash.events.Event;
	
	public class TabBarEvent extends Event
	{
		public static const CLOSE_TAB : String = "closeTab";
		
		public var index : int = -1;
		
		public function TabBarEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
	}
}