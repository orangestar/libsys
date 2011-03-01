package project.libsys.components
{
	import mx.core.FlexGlobals;
	import mx.styles.CSSStyleDeclaration;
	
	import project.libsys.skins.IconButtonSkin;
	
	import spark.components.Button;
	
	[Style(name="icon", format="Class")]
	
	public class IconButton extends Button
	{
		private static var classConstructed : Boolean = classConstruct();
		
		private static function classConstruct():Boolean {
			if (!FlexGlobals.topLevelApplication.styleManager.getStyleDeclaration("project.libsys.components.IconButton")) {
				var styles:CSSStyleDeclaration = new CSSStyleDeclaration();
				styles.defaultFactory = function():void {
					this.skinClass = Class(IconButtonSkin);
				}
				FlexGlobals.topLevelApplication.styleManager.setStyleDeclaration("project.libsys.components.IconButton", styles, true);
			}
			return true;
		}
		
		public function IconButton()
		{
			super();
		}
		
	}
}