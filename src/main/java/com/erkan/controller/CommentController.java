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

import com.erkan.entity.Comment;
import com.erkan.service.CommentService;

@RestController
public class CommentController {

	private CommentService commentService;

    public CommentController(@Autowired CommentService commentService) {
        this.commentService = commentService;
    }
	
	
    // get all comments
	@GetMapping("/comments")
	public List<Comment> getAll(){
		return commentService.getAll();
	}
	
	// get the comment by given comment id
	@GetMapping("/comments/{id}")
	public Comment getById(@PathVariable int id){
		return commentService.getById(id)
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	// it is defined an only one method in comment service "save" it is to Update and to save
	//create a new comment
	@PostMapping("/comments")
    public Comment create(@RequestBody Comment comment) {
        return commentService.save(comment);
    }
	
	//update given comment
	@PutMapping("/comments")
    public Comment update(@RequestBody Comment comment) {
        return commentService.save(comment);
    }

	//delete given commentId
    @DeleteMapping("comments/{id}")
    public void deleteById(@PathVariable Integer id) {
    	commentService.deleteById(id);
    }
    
    //delete given comment
    @DeleteMapping("comments")
    public void deleteComment(@PathVariable Comment comment) {
    	commentService.delete(comment);
    }
	
}