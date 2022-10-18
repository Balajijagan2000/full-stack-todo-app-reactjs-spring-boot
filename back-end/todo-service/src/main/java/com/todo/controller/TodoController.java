package com.todo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.entity.Todo;
import com.todo.service.TodoService;
import com.todo.utils.DateUtils;

@RestController
@RequestMapping("/todos")
@CrossOrigin(origins="http://localhost:3000")
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	// api returns all todos from database
	@GetMapping 
	public ResponseEntity<Object> getAllTodos() {
		
		List<Todo>  todos = todoService.getAllTodosFromDb();
		
		return new ResponseEntity<>(todos,HttpStatus.OK);
	}
	
	// api returns todo based on given id in URI
	@GetMapping("/{todoId}")
	public ResponseEntity<Object> getTodoById(@PathVariable int todoId) {
		
		Todo todo = todoService.getTodoByIdFromDb(todoId);
		
		return new ResponseEntity<>(todo,HttpStatus.OK);
	}
	
	// api to save the todo in database
	@PostMapping
	public ResponseEntity<Object> saveTodo(@RequestBody Todo todo) {
		

		String newDate = DateUtils.convertToDateString(todo.getCreatedAt());
		todo.setCreatedAt(newDate);
		
		return new ResponseEntity<>(todoService.saveTodoToDb(todo),HttpStatus.CREATED);

	}
	
	
	// api to get the todo based on completion status
	@GetMapping("/bystatus/{status}")
	public ResponseEntity<Object> getTodoByStatus(@PathVariable boolean status) {
		
		List<Todo> todos = todoService.getTodosByCompletedStatus(status);
		
		return new ResponseEntity<>(todos,HttpStatus.OK);
	}
	
	
	// api to update a todo 
	@PutMapping("/update")
	public ResponseEntity<Object> updateTodo(@RequestBody Todo todo) {
		Todo updatedTodo = todoService.updateTodoInDb(todo);
		
		
		
		return new ResponseEntity<>(updatedTodo,HttpStatus.CREATED);
	}
	
	// api to remove given todo from database
	@DeleteMapping("/{todoId}")
	public ResponseEntity<Object> deleteTodo(@PathVariable int todoId) {
		Todo deletedTodo = todoService.removeTodoFromDb(todoId);
		return new ResponseEntity<>(deletedTodo,HttpStatus.OK);
	}
	
	
	
	
	// API for status check...
	@GetMapping("/health")
	public String serviceStatus() {
		return "Service is up...";
	}
	

}
