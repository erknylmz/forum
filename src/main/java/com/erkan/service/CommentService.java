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
	
	/**
	 * GetAll method gets all comments from database
	 * @return List<Comment>
	 */
	public List<Comment> getAll(){
		return commentRepo.findAll();
	}
	
	/**
	 * GetById method gets given comment id from database
	 * @param commentId
	 * @return Optional <Comment>
	 */
	public Optional <Comment> getById(int commentId){
		return commentRepo.findById(commentId);
	}
	
	/**
	 * Save method saves or updates a comment on database
	 * @param newComment
	 * @return Comment
	 */
	public Comment save(Comment newComment) {
		return commentRepo.save(newComment);
	}
	
	/**
	 * Delete  method deletes given comment on database
	 * @param comment
	 */
	public void delete(Comment comment) {
		commentRepo.delete(comment);
	}

	/**
	 * GetAllByArticleId method gets 
	 * all comments belong to given articleId
	 * @param parseInt
	 * @return List<Comment>
	 */
	public List<Comment> getAllByArticleId(int parseInt) {
		return commentRepo.findByArticle_id(parseInt);
	
	}

}


