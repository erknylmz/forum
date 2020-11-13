package com.erkan.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.erkan.entity.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{
	
	/**
	 * FindByArticle_id gets All Comments 
	 * from database about the Article with given Id
	 * @param parseInt
	 * @return List<Comment>
	 */
	List<Comment> findByArticle_id(int parseInt);
}
