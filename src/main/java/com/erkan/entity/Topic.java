package com.erkan.entity;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity   //ORM
public class Topic {

	@Id
	@GeneratedValue
	private int id;
	
	private String topicName;
	
	@OneToMany
	private List<Article> articleList;

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Topic [id=" + id + ", topicName=" + topicName + "]";
	}

	

	

}