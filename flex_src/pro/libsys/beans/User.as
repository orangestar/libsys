package pro.libsys.beans
{
	[Bindable]
	[RemoteClass(alias="pro.libsys.bean.User")]
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