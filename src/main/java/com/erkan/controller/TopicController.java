package com.erkan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.erkan.entity.Topic;
import com.erkan.service.TopicService;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	
	@RequestMapping("/topics")
	public List<Topic> getAll(){
		return topicService.getAll();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getById(@PathVariable int id){
		return topicService.getById(id)
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

}