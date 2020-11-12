package com.erkan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erkan.entity.Comment;
import com.erkan.repos.CommentRepo;

@Service
public class CommentService {
	
	@Autowired
	CommentRepo commentRepo;
	
	public List<Comment> getAll(){
		return commentRepo.findAll();
	}
	
	public Optional <Comment> getById(int commentId){
		return commentRepo.findById(commentId);
	}
	
	public Comment create(Comment newComment) {
		
		return commentRepo.save(newComment);
	}
	
	public void delete(int commentId) {
		
		commentRepo.deleteById(commentId);
	
	}
	
	public Comment update(Comment updatedComment) {
        return commentRepo.save(updatedComment);
    }

}


