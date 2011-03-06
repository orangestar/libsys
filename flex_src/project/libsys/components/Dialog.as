package project.libsys.components
{
	import flash.display.DisplayObject;
	
	import mx.core.FlexGlobals;
	import mx.events.CloseEvent;
	import mx.managers.PopUpManager;
	
	import spark.components.TitleWindow;
	import spark.layouts.HorizontalLayout;
	
	public class Dialog extends TitleWindow
	{
		public function Dialog()
		{
			super();
			
			var horizontalLayout : HorizontalLayout = new HorizontalLayout();
			horizontalLayout.paddingTop = 4;
			horizontalLayout.paddingBottom = 4;
			horizontalLayout.horizontalAlign = "center";
			horizontalLayout.verticalAlign = "middle";
			this.controlBarLayout = horizontalLayout;
			
			this.addEventListener(CloseEvent.CLOSE, onDialogClose);
		}
		
		private function onDialogClose(event : CloseEvent) : void
		{
			close();
		}
		
		public function show(parent:DisplayObject = null, modal:Boolean = false) : void
		{
			PopUpManager.addPopUp(this, parent ? parent : DisplayObject(FlexGlobals.topLevelApplication), modal);
			PopUpManager.centerPopUp(this);
		}
		
		public function close() : void
		{
			PopUpManager.removePopUp(this);
		}
		
	}
}