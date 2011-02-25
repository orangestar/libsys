package project.libsys.beans
{
	[Bindable]
	[RemoteClass(alias="project.libsys.bean.Reader")]
	public class Reader
	{
		public function Reader()
		{
		}
		
		public var id : int;
		
		public var name : String;
		
		public var male : Boolean;
	}
}
