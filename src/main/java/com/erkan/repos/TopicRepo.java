package com.erkan.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erkan.entity.Topic;

public interface TopicRepo extends JpaRepository<Topic, Integer> {

}
