package com.cos.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.cos.blog.model.Task;
import com.cos.blog.service.TaskService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/tasks")
@Slf4j
public class TaskController {

	@Autowired
	private TaskService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Task createTask(@RequestBody Task task) {
		return service.addTask(task);
	}
	
	@GetMapping
	public List<Task> getTasks() {
		log.info("Get all tasks");
		//log.error()
		//log.debug()
		return service.findAllTasks();
	}
	
	@GetMapping("/{taskId}")
	public Task getTask(@PathVariable String taskId) {
		log.info("Get special task");
		return service.getTaskByTaskId(taskId);
	}
	
	@GetMapping("/severity/{severity}")
	public List<Task> getTaskUsingSeverity(@PathVariable int severity) {
		return service.getTaskBySeverity(severity);
	}
	
	@GetMapping("/assignee/{assignee}")
	public List<Task> getTaskUsingAssignee(@PathVariable String assignee) {
		return service.getTaskByAssignee(assignee);
	}
	
	@PutMapping
	public Task modifyTask(@RequestBody Task task) {
		return service.updateTask(task);
	}
	
	@DeleteMapping("/{taskId}")
	public String deleteTask(@PathVariable String taskId) {
		return service.deleteTask(taskId);
	}
}
