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
	
	
	
	public List<Article> getAll(){
		return articleRepo.findAll();
	}
	
	public Optional <Article> getById(int articleId){
		return articleRepo.findById(articleId);
	}
	
	public Article create(Article newArticle) {
		
		
		return articleRepo.save(newArticle);
	}

	public void deleteArticle(int articleId) {
		
		articleRepo.deleteById(articleId);
	
	}

	public Article update(Article updatedArticle) {
        return articleRepo.save(updatedArticle);
    }

	
	
}
