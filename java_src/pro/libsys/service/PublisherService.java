package pro.libsys.service;

import java.util.List;

import pro.libsys.bean.Publisher;

public interface PublisherService {

	public boolean addPublisher(Publisher publisher);
	
	public boolean editPublisher(Publisher publisher);
	
	public boolean deletePublisher(int publisherId);
	
	public List<Publisher> getPublishers();
	
	public Publisher getPublisher();
	
}
