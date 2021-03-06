package com.erkan.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * This class has id, topicName and articles.
 * Topic and Article classes have a ManyToMany relationship.
 * Each topic can have many articles and each article can belong to many topics.
 * @author Erkan Yilmaz
 *
 */
@Entity
public class Topic {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String topicName;
	
	@ManyToMany 
	private List<Article> articles;
	

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public List<Article> getArticleList() {
		return articles;
	}

	public void setArticleList(List<Article> articleList) {
		this.articles = articleList;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Topic [id=" + id + ", topicName=" + topicName + "]";
	}

}