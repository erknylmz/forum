package com.erkan.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.erkan.entity.Topic;

public interface TopicRepo extends JpaRepository<Topic, Integer> {
	
	/**
	 * FindByArticles_id method gets All Topics from database about the Article with given Id.
	 * @param articleId
	 * @return List<Topic>
	 */
	List<Topic> findByArticles_id(int articleId);
	
	
}
