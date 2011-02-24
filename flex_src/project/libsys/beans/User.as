package project.libsys.beans
{
	[Bindable]
	[RemoteClass(alias="project.libsys.bean.User")]
	public class User
	{
		public function User()
		{
		}
		
		public var id : int;
		
		public var name : String;
		
		public var password : String;
	}
}