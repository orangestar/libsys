package project.libsys.service.impl;

import java.util.List;

import project.libsys.bean.Publisher;
import project.libsys.dao.PublisherDao;
import project.libsys.service.PublisherService;

public class PublisherServiceImpl implements PublisherService {
	
	private PublisherDao publisherDao;

	@Override
	public Publisher addPublisher(Publisher publisher) {
		publisherDao.addPublisher(publisher);
		return publisher;
	}

	@Override
	public boolean deletePublisher(int publisherId) {
		return publisherDao.delPublisher(publisherId);
	}

	@Override
	public boolean editPublisher(Publisher publisher) {
		return publisherDao.editPublisher(publisher);
	}

	@Override
	public Publisher getPublisher() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Publisher> getPublishers() {
		return publisherDao.getPublishers();
	}
	
	public PublisherDao getPublisherDao() {
		return publisherDao;
	}

	public void setPublisherDao(PublisherDao publisherDao) {
		this.publisherDao = publisherDao;
	}

}
