package com.cos.blog.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.blog.model.Task;
import com.cos.blog.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository repository;
	
	public Task addTask(Task task) {
		task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
		return repository.save(task);
	}
	
	public List<Task> findAllTasks() {
		return repository.findAll();
	}
	
	public Task getTaskByTaskId(String taskId) {
		return repository.findById(taskId).get();
	}
	
	public List<Task> getTaskBySeverity(int severity) {
		return repository.findBySeverity(severity);
	}
	
	public List<Task> getTaskByAssignee(String assignee) {
		return repository.getTaskByAssignee(assignee);
	}
	
	public Task updateTask(Task task) {
		// get the existing document from DB
		// populate new value from request to existing object/entity/document
		Task originTask = repository.findById(task.getTaskId()).get();
		originTask.setDescription(task.getDescription());
		originTask.setSeverity(task.getSeverity());
		originTask.setAssignee(task.getAssignee());
		originTask.setStoryPoint(task.getStoryPoint());
		
		return repository.save(originTask);
	}
	
	public String deleteTask(String taskId) {
		repository.deleteById(taskId);
		return taskId + " task deleted from dashboard";
	}
}
