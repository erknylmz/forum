package com.erkan.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.erkan.entity.Article;
import com.erkan.entity.Topic;
import com.erkan.service.ArticleService;
import com.erkan.service.TopicService;

/**
 *  
 * This class controllers some article methods.
 * @author Erkan Yilmaz
 *
 */
@RestController
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private TopicService topicService;
	
	 
	public ArticleController(@Autowired ArticleService artcileService) {
	     this.articleService = artcileService;
	}

	
	/**
	 * GetAll method 
	 * Without given any Topic id, get all the Articles, 
	 * with given Topic id as a request parameter 
	 * get all the articles in topic with this id
	 * @param topicId
	 * @return List<Article>
	 */
	@GetMapping("/articles")
	public List<Article> getAll(@RequestParam(required=false) String topicId){
		
		if (topicId==null) {
			return articleService.getAll();
		}
		
		else {
			Optional<Topic> topic=topicService.getById(Integer.parseInt(topicId));
			return topic.orElse(new Topic()).getArticleList();
		}	
	}
	
	/**
	 * getById methods gets articles by given id or response Not Found
	 * @param id
	 * @return
	 */
	@GetMapping("/articles/{id}")
	public Article getById(@PathVariable int id){
		return articleService.getById(id)
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	
	/**
	 * Create method creates new article
	 * @param newArticle
	 * @return
	 */
	@PostMapping("/articles")
	public Article create(@RequestBody Article newArticle) {
		return articleService.save(newArticle);
	}
	
	/**
	 * Update method updates articles by given article
	 * It is defined only one method in ArticleService "save()" to update or to save 
	 * @param article
	 * @return
	 */
	@PutMapping("/articles")
    public Article update(@RequestBody Article article) {
        return articleService.save(article);
    }

    /**
     * DeleteByArticle method delete given article
     * @param article
     */
    @DeleteMapping("articles")
    public void deleteByArticle(@RequestBody Article article) {
        articleService.delete(article);
    }
       
}