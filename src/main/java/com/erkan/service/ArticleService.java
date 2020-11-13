package com.erkan.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.erkan.entity.Article;
import com.erkan.repos.ArticleRepo;

@Service
public class ArticleService {
	@Autowired
	ArticleRepo articleRepo;
	
	// get all articles
	public List<Article> getAll(){
		return articleRepo.findAll();
	}
	
	//get by given article id 
	public Optional <Article> getById(int articleId){
		return articleRepo.findById(articleId);
	}
	
	//this method is for both to update and to save
	//get by given article id 
	public Article save(Article newArticle) {
		return articleRepo.save(newArticle);
	}

	//delete by given article id
	public void deleteArticleById(int articleId) {
		articleRepo.deleteById(articleId);
	
	}
	
	//delete by given article
	public void deleteArticle(Article article) {
		articleRepo.delete(article);
	}	
}
