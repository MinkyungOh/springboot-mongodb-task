package com.cos.blog.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cos.blog.model.Task;

public interface TaskRepository extends MongoRepository<Task, String> {

	List<Task> findBySeverity(int severity);
	
	// "{assignee: ?0, fieldName: ?1, ... }"
	@Query("{assignee: ?0 }")
	List<Task> getTaskByAssignee(String assignee);
}
