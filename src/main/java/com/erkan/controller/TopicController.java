package com.erkan.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.erkan.entity.Topic;
import com.erkan.service.TopicService;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	/**
	 * GetAllByArticleId method gets topics belong given article id
	 * @param articleId
	 * @return List<Topic>
	 */
	@GetMapping("/topics")
	public List<Topic> getAllByArticleId(@RequestParam(required=false) String articleId){
		if (articleId==null) {
			return topicService.getAll();
		}
		else {
			return topicService.getAllByArticleId(Integer.parseInt(articleId));
		}
	}
	
	
	/**
	 * Create method creates new topic
	 * @param topic
	 * @return Topic
	 */
	@PostMapping("/topics")
    public Topic create(@RequestBody Topic topic) {
        return topicService.save(topic);
    }
	
	/**
	 * Update method updates given topic
	 * @param topic
	 * @return Topic
	 */
	@PutMapping("/topics")
    public Topic update(@RequestBody Topic topic) {
        return topicService.save(topic);
    }
    
    /**
     * Delete method deletes given topic
     * @param topic
     */
    @DeleteMapping("topics")
    public void delete(@PathVariable Topic topic) {
    	topicService.delete(topic);
    }  
}