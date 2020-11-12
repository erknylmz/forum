package com.erkan.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erkan.entity.Article;



public interface ArticleRepo extends JpaRepository<Article, Integer>{
	
	
	
}