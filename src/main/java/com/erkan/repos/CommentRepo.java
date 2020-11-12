package com.erkan.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erkan.entity.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
