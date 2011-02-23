package pro.libsys.service;

import java.util.List;

import pro.libsys.bean.Reader;

public interface ReaderService {

	public boolean addReader(Reader reader);
	
	public boolean editReader(Reader reader);
	
	public boolean deleteReader(int readerId);
	
	public List<Reader> getReaders();
	
	public Reader getReader();
	
}
