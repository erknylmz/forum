package com.erkan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.erkan.entity.Article;
import com.erkan.service.ArticleService;


@RestController
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/")
	@ResponseBody
	public String sayHello(){
		System.out.println("hello cagirkdi");
		return "Hello";
	}
	@RequestMapping("/articles")
	public List<Article> getAll(){
		return articleService.getAll();
	}
	@RequestMapping("/articles/{id}")
	public Article getById(@PathVariable int id){
		return articleService.getById(id)
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
}