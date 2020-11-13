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
	
	//get all comments
	public List<Comment> getAll(){
		return commentRepo.findAll();
	}
	
	//get given comment id
	public Optional <Comment> getById(int commentId){
		return commentRepo.findById(commentId);
	}
	
	//save or update comment
	public Comment save(Comment newComment) {
		return commentRepo.save(newComment);
	}
	
	//delete given comment id
	public void deleteById(int commentId) {	
		commentRepo.deleteById(commentId);
	}
	
	//delete given comment
	public void delete(Comment comment) {
		commentRepo.delete(comment);
	}

}


