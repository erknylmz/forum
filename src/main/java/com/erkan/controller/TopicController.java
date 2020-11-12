package com.erkan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.erkan.entity.Topic;
import com.erkan.service.TopicService;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	
	@GetMapping("/topics")
	public List<Topic> getAll(){
		return topicService.getAll();
	}
	
	@GetMapping("/topics/{id}")
	public Topic getById(@PathVariable int id){
		return topicService.getById(id)
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/topics")
    public Topic create(@RequestBody Topic topic) {
        return topicService.create(topic);
    }
	
	@PutMapping("/topics")
    public Topic update(@RequestBody Topic topic) {
        return topicService.update(topic);
    }

    @DeleteMapping("topic/{id}")
    public void delete(@PathVariable Integer id) {
    	topicService.delete(id);
    }

}