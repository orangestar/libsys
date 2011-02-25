package project.libsys.beans
{
	[Bindable]
	[RemoteClass(alias="project.libsys.bean.Publisher")]
	public class Publisher
	{
		public function Publisher()
		{
		}
		
		public var id : int;
		
		public var name : String;
	}
}
