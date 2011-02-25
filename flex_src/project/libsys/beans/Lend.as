package project.libsys.beans
{
	[Bindable]
	[RemoteClass(alias="project.libsys.bean.Lend")]
	public class Lend
	{
		public function Lend()
		{
		}
		
		public var id : int;
		
		public var book : Book;
		
		public var reader : Reader;
		
		public var lendDate : Date;
		
		public var user : User;
	}
}
