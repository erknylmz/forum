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
import org.springframework.web.bind.annotation.RequestParam;
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
	
    /**
     * GetAll method gets all comments
     * @param articleId
     * @return List<Comment>
     */
	@GetMapping("/comments")
	public List<Comment> getAll(@RequestParam(required=false) String articleId){
		if (articleId==null) {
			return commentService.getAll();
		}
		
		else {
			return commentService.getAllByArticleId(Integer.parseInt(articleId));
		}	
	}
	
	/**
	 * GetById  method gets given comment id
	 * @param id
	 * @return Comment
	 */
	@GetMapping("/comments/{id}")
	public Comment getById(@PathVariable int id){
		return commentService.getById(id)
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	/**
	 * Create method creates a new comment
	 * @param comment
	 * @return Comment
	 */
	@PostMapping("/comments")
    public Comment create(@RequestBody Comment comment) {
        return commentService.save(comment);
    }
	
	/**
	 * Update method updates a given comment
	 * @param comment
	 * @return Comment
	 */
	@PutMapping("/comments")
    public Comment update(@RequestBody Comment comment) {
        return commentService.save(comment);
    }
    
    /**
     * Delete method deletes a given comment
     * @param comment
     */
    @DeleteMapping("comments")
    public void delete(@PathVariable Comment comment) {
    	commentService.delete(comment);
    }
	
}