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
		
		public function close() : Reader
		{
			var r : Reader = new Reader();
			r.id = this.id;
			r.name = this.name;
			r.male = this.male;
			return r;
		}
	}
}
