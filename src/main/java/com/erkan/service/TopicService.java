package com.erkan.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.erkan.entity.Topic;
import com.erkan.repos.ArticleRepo;
import com.erkan.repos.TopicRepo;

@Service
public class TopicService {
	
	@Autowired
	TopicRepo topicRepo;
	@Autowired
	ArticleRepo articleRepo;
	
	//get all topics
	public List<Topic> getAll(){
		return topicRepo.findAll();
	}
	
	//get topic by given topic id
	public Optional <Topic> getById(int topicId){
		return topicRepo.findById(topicId);
	}
	
	//save or update topic
	public Topic save(Topic newTopic) {
		return topicRepo.save(newTopic);
	}
	
	//delete the comment by comment id
	public void deleteById(int topicId) {
		topicRepo.deleteById(topicId);
	}
	
	//delete given topic
	public void delete(Topic topic) {
		topicRepo.delete(topic);
	}

	//get topics by given article id
	public List<Topic> getAllByArticleId(int articleId) {
		return topicRepo.findAll().stream()      			// find all topics and stream
			.filter(t -> t.getArticleList()  				// filter by predicate 
			.contains(articleRepo.findById(articleId)))     // if contains this article
			.collect(Collectors.toList());  			    // collect all into List	
	}
}
