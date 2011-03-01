package project.libsys.components
{
	import mx.core.FlexGlobals;
	import mx.styles.CSSStyleDeclaration;
	
	import project.libsys.skins.ToolBarSkin;
	
	import spark.components.SkinnableContainer;
	
	public class ToolBar extends SkinnableContainer
	{
		private static var classConstructed : Boolean = classConstruct();
		
		private static function classConstruct():Boolean {
			if (!FlexGlobals.topLevelApplication.styleManager.getStyleDeclaration("project.libsys.components.ToolBar")) {
				var styles:CSSStyleDeclaration = new CSSStyleDeclaration();
				styles.defaultFactory = function():void {
					this.skinClass = Class(ToolBarSkin);
				}
				FlexGlobals.topLevelApplication.styleManager.setStyleDeclaration("project.libsys.components.ToolBar", styles, true);
			}
			return true;
		}
		
		public function ToolBar()
		{
			super();
			this.percentWidth = 100;
			this.height = 28;
		}
		
	}
}