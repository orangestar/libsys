package project.libsys.components
{
	import flash.events.MouseEvent;
	
	import mx.core.FlexGlobals;
	import mx.styles.CSSStyleDeclaration;
	
	import project.libsys.events.TabBarEvent;
	import project.libsys.skins.CloseableTabBarButtonSkin;
	
	import spark.components.Button;
	import spark.components.ButtonBarButton;
	
	[Event(name='closeTab',type='project.libsys.events.TabBarEvent')]
	
	public class CloseableTabBarButton extends ButtonBarButton
	{
		[SkinPart(required="false")]
		public var closeButton : Button;
		
		private var _closeable : Boolean;
		
		private static var classConstructed : Boolean = classConstruct();
		
		public function CloseableTabBarButton()
		{
			super();
			mouseChildren = true;
		}
		
		[Bindable]
		public function get closeable() : Boolean
		{
			return _closeable;
		}
		
		private static function classConstruct() : Boolean
		{
			if (!FlexGlobals.topLevelApplication.styleManager.getStyleDeclaration("project.libsys.components.CloseableTabBarButton")) {
				var styles:CSSStyleDeclaration = new CSSStyleDeclaration();
				styles.defaultFactory = function():void {
					this.skinClass = Class(CloseableTabBarButtonSkin);
				}
				FlexGlobals.topLevelApplication.styleManager.setStyleDeclaration("project.libsys.components.CloseableTabBarButton", styles, true);
			}
			return true;
		}
		
		public function set closeable(value : Boolean) : void
		{
			if (_closeable != value) {
				_closeable = value;
				closeButton.visible = value;
				labelDisplay.right = (value ? 30 : 14);
			}
		}
		
		private function closeHandler(e : MouseEvent) : void
		{
			var event : TabBarEvent = new TabBarEvent(TabBarEvent.CLOSE_TAB, true);
			event.index = itemIndex;
			dispatchEvent(event);
		}
		
		override protected function partAdded(partName:String, instance:Object):void
		{
			super.partAdded(partName, instance);
			
			if (instance == closeButton) {
				closeButton.addEventListener(MouseEvent.CLICK, closeHandler);
				closeButton.visible = closeable;
			} else if (instance == labelDisplay) {
				labelDisplay.right = (closeable ? 30 : 14);
			}
		}
		
		override protected function partRemoved(partName:String, instance:Object):void {
			super.partRemoved(partName, instance);
			
			if (instance == closeButton) {
				closeButton.removeEventListener(MouseEvent.CLICK, closeHandler);
			}
		}
		
	}
}