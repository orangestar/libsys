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
		
		public function clone() : Book
		{
			var p : Publisher = new Publisher();
			p.id = this.publisher.id;
			p.name = this.publisher.name;
			var b : Book = new Book();
			b.id = this.id;
			b.title = this.title;
			b.author = this.author;
			b.publisher = p;
			return b;
		}
		
	}
}
