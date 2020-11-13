package com.erkan.service;

import java.util.List;
import java.util.Optional;
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
	
	/**
	 * GetAll method gets all topics from database
	 * get all topics
	 * @return List<Topic>
	 */
	public List<Topic> getAll(){
		return topicRepo.findAll();
	}
	
	/**
	 * GetById method gets given topic id from database
	 * @param topicId
	 * @return Optional <Topic> 
	 */
	public Optional <Topic> getById(int topicId){
		return topicRepo.findById(topicId);
	}
	
	/**
	 * 
	 * Save method is for both to update and to save on database
	 * by given topic 
	 * @param newTopic
	 * @return
	 */
	public Topic save(Topic newTopic) {
		return topicRepo.save(newTopic);
	}
	
	/**
	 * Delete method deletes given topic on database
	 * @param topic
	 */
	public void delete(Topic topic) {
		topicRepo.delete(topic);
	}

	/**
	 * GetAllByArticleId method gets all topics belong given article id
	 * @param articleId
	 * @return List<Topic>
	 */
	public List<Topic> getAllByArticleId(int articleId) {
		return topicRepo.findByArticles_id(articleId);
	}
}
