package com.erkan.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.erkan.entity.Article;
import com.erkan.repos.ArticleRepo;

/*
 * This class has some artcileRepo methods.
 */
@Service
public class ArticleService {
	
	@Autowired
	ArticleRepo articleRepo;
	
	/**
	 * GetAll method gets all articles from database
	 * @return List<Article>
	 */
	public List<Article> getAll(){
		return articleRepo.findAll();
	}
	
	/**
	 * GetById method gets given article id from database
	 * 
	 * @param articleId
	 * @return Optional <Article>
	 */
	public Optional <Article> getById(int articleId){
		return articleRepo.findById(articleId);
	}
	
	/**
	 * Save method is for both to update and to save on database
	 * by given article id 
	 * @param newArticle
	 * @return Article
	 */
	public Article save(Article newArticle) {
		return articleRepo.save(newArticle);
	}
	
	/**
	 * DeleteArticle method deletes given article on database
	 * @param article
	 */
	public void deleteArticle(Article article) {
		articleRepo.delete(article);
	}
}
