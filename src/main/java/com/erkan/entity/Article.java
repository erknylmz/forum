package com.erkan.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * This class has title, body, authorName fields  and a list from Topic. 
 * The class has  also a ManyToMany relationship with Topic class.
 * 
 * @author Erkan Yilmaz
 *
 */
@Entity
public class Article {
	
	/**
	 * id must be unique. Spring generates it automatically
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	/**
	 * Article has to have at least "title"
	 */
	@Column(nullable=false)
	private  String title;
	
	private String body;
	
	private String authorName;
	
	/**
	 * Article and Topic classes have a ManyToMany relationship.
	 * Each topic can have many articles and 
	 * each article can belong to many topics.
	 */
	@ManyToMany
	private List<Topic> topics;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getId() {
		return id;
	}

	
	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", body=" + body + ", authorName=" + authorName + "]";
	}

}
