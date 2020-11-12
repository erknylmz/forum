package com.erkan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity   //ORM
public class Comment {
	
	@Id
	@GeneratedValue
	private int id;
	
	/* bunu yazmaya gerek yok. cunku Artcile da tanimladik?
	@ManyToOne
	private Article article; */

	private String body;
	
	private String authorName;


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

	@Override
	public String toString() {
		return "Topic [id=" + id + ", body=" + body + ", authorName=" + authorName + "]";
	}
	

}