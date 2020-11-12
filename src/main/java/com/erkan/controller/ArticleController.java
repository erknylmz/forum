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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.erkan.entity.Article;
import com.erkan.service.ArticleService;


@RestController
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	 
	public ArticleController(@Autowired ArticleService artcileService) {
	     this.articleService = artcileService;
	}

	
	@GetMapping("/articles")
	public List<Article> getAll(){
		return articleService.getAll();
	}
	
	
	@GetMapping("/articles/{id}")
	public Article getById(@PathVariable int id){
		return articleService.getById(id)
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	
	// Create an Article
	@PostMapping("/articles")
	public Article create(@RequestBody Article newArticle) {
	
		return articleService.create(newArticle);
	}
	
	@PutMapping("/articles")
    public Article update(@RequestBody Article article) {
        return articleService.update(article);
    }

    @DeleteMapping("artciles/{id}")
    public void delete(@PathVariable Integer id) {
        articleService.deleteArticle(id);
    }

}