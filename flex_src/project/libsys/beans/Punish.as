package project.libsys.beans
{
	[Bindable]
	[RemoteClass(alias="project.libsys.bean.Punish")]
	public class Punish
	{
		public function Punish()
		{
		}
		
		public var id : int;
		
		public var cause : String;
		
		public var finished : Boolean;
		
		public var money : Number;
		
		public var lend : Lend;
	}
}
