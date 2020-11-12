package com.erkan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erkan.entity.Topic;
import com.erkan.repos.TopicRepo;

@Service
public class TopicService {
	@Autowired
	TopicRepo topicRepo;
	
	public List<Topic> getAll(){
		return topicRepo.findAll();
	}
	
	public Optional <Topic> getById(int topicId){
		return topicRepo.findById(topicId);
	}
	
	public Topic saveNewTopic(Topic newTopic) {
		
		return topicRepo.save(newTopic);
	}
	
	public void deleteTopic(int topicId) {
		
		topicRepo.deleteById(topicId);
	
	}
	

}
