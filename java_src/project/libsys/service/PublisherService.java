package project.libsys.service;

import java.util.List;

import project.libsys.bean.Publisher;

public interface PublisherService {

	public Publisher addPublisher(Publisher publisher);
	
	public boolean editPublisher(Publisher publisher);
	
	public boolean deletePublisher(int publisherId);
	
	public List<Publisher> getPublishers();
	
	public Publisher getPublisher();
	
}
