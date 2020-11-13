package com.erkan.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.erkan.entity.Topic;
import com.erkan.service.TopicService;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	//get all topics
	@GetMapping("/topics")
	public List<Topic> getAll(){
		return topicService.getAll();
	}
	
	//get topics by given article id
	@GetMapping("/topics/articleId={articleId}")
	public List<Topic> getAllByArticleId(@PathVariable int articleId){
		return topicService.getAllByArticleId(articleId);
	}
	
	//it is defined a method in TopicService for both to update and to save
	//create new topic
	@PostMapping("/topics")
    public Topic create(@RequestBody Topic topic) {
        return topicService.save(topic);
    }
	
	//update given topic
	@PutMapping("/topics")
    public Topic update(@RequestBody Topic topic) {
        return topicService.save(topic);
    }

	//delete given topic id
    @DeleteMapping("topics/{id}")
    public void deleteById(@PathVariable Integer id) {
    	topicService.deleteById(id);
    }
    
  //delete given topic
    @DeleteMapping("topics")
    public void delete(@PathVariable Topic topic) {
    	topicService.delete(topic);
    }  
}