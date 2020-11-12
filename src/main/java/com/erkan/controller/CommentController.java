package com.erkan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.erkan.entity.Comment;
import com.erkan.service.CommentService;

@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/comments")
	public List<Comment> getAll(){
		return commentService.getAll();
	}
	
	@RequestMapping("/comments/{id}")
	public Comment getById(@PathVariable int id){
		return commentService.getById(id)
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

}

