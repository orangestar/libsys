package project.libsys.beans
{
	[Bindable]
	[RemoteClass(alias="project.libsys.bean.Book")]
	public class Book
	{
		public function Book()
		{
		}
		
		public var id : int;
		
		public var title : String;
		
		public var author : String;
		
		public var publisher : Publisher;
	}
}
