package project.libsys.components
{
	import mx.collections.IList;
	import mx.containers.ViewStack;
	import mx.core.FlexGlobals;
	import mx.styles.CSSStyleDeclaration;
	import mx.utils.ObjectUtil;
	
	import project.libsys.events.TabBarEvent;
	import project.libsys.skins.CloseableTabBarSkin;
	import project.libsys.utils.AppContext;
	
	import spark.components.NavigatorContent;
	import spark.components.TabBar;
	
	public class CloseableTabBar extends TabBar
	{
		
		private static var classConstructed : Boolean = classConstruct();
		
		public function CloseableTabBar()
		{
			super();
		}
		
		private static function classConstruct() : Boolean
		{
			if (!FlexGlobals.topLevelApplication.styleManager.getStyleDeclaration("project.libsys.components.CloseableTabBar")) {
				var styles:CSSStyleDeclaration = new CSSStyleDeclaration();
				styles.defaultFactory = function():void {
					this.skinClass = Class(CloseableTabBarSkin);
				}
				FlexGlobals.topLevelApplication.styleManager.setStyleDeclaration("project.libsys.components.CloseableTabBar", styles, true);
			}
			return true;
		}
		
		public function setCloseableTab(index : int, closeable : Boolean) : void
		{
			if(0 <= index && index < dataGroup.numElements) {
				var btn : CloseableTabBarButton = dataGroup.getElementAt(index) as CloseableTabBarButton;
				btn.closeable = closeable;
			}
		}
		
		public function isTabCloseable(index : int) : Boolean
		{
			if(0 <= index && index < dataGroup.numElements) {
				return (dataGroup.getElementAt(index) as CloseableTabBarButton).closeable;
			}
			return false;
		}
		
		private function closeHandler(e : TabBarEvent):void
		{
			if(dataProvider is ViewStack) {
				var navPage : NavigatorContent = NavigatorContent(ViewStack(dataProvider).getChildAt(e.index));
				var className : String = ObjectUtil.getClassInfo(navPage.getElementAt(0)).name;
				var comp : String = className.substr(className.indexOf("::") + 2);
				AppContext.instance.removeModuleIndex(comp);
			}
			closeTab(e.index, this.selectedIndex);
		}
		
		public function closeTab(closedTab : int, selectedTab : int) : void
		{
			if (dataProvider.length == 0) {
				return;
			}
			
			if (dataProvider is IList) {
				dataProvider.removeItemAt(closedTab);
			} else if (dataProvider is ViewStack){
				//remove the entire child from the dataProvider, which also removes it from the ViewStack
				(dataProvider as ViewStack).removeChildAt(closedTab);
			}
			
			//adjust selectedIndex appropriately
			if (dataProvider.length == 0) {
				selectedIndex = -1;
			} else if (closedTab < selectedTab) {
				selectedIndex = selectedTab - 1;
			} else if (closedTab == selectedTab) {
				selectedIndex = (selectedTab == 0 ? 0 : selectedTab - 1);
			} else {
				selectedIndex = selectedTab;
			}
		}
		
		protected override function partAdded(partName:String, instance:Object):void
		{
			super.partAdded(partName, instance);
			
			if (instance == dataGroup) {
				dataGroup.addEventListener(TabBarEvent.CLOSE_TAB, closeHandler);
			}
		}
		
		protected override function partRemoved(partName:String, instance:Object):void
		{
			super.partRemoved(partName, instance);
			
			if (instance == dataGroup) {
				dataGroup.removeEventListener(TabBarEvent.CLOSE_TAB, closeHandler);
			}
		}

	}
}