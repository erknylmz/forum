package com.erkan.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erkan.entity.Article;



public interface ArticleRepo extends JpaRepository<Article, Integer>{
	
	List<Article> findAllByCommentId(Integer commentId);
    List<Article> findAllByTopicId(Integer topicId);

	
}