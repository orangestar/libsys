package project.libsys.service;

import project.libsys.bean.Lend;

public interface LendService {
	
	public Lend lendBook(Lend lend);
	
	public Lend returnBook(Lend lend);

}
