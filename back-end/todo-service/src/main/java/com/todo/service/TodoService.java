package com.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.entity.Todo;
import com.todo.exceptions.BaseException;
import com.todo.repository.TodoRepository;

@Service
public class TodoService {
	
	
	@Autowired
	private TodoRepository todoRepo;
	
	
	public List<Todo> getAllTodosFromDb() {
		return todoRepo.findAll();
	}
	
	public Todo saveTodoToDb(Todo todo) {
		
		
		return todoRepo.save(todo);
	}
	
	public Todo updateTodoInDb(Todo newTodo) {
		return todoRepo.save(newTodo);
	}
	
	public Todo removeTodoFromDb(int todoId) {
		Optional<Todo> todo = todoRepo.findById(todoId);
		
		if(todo.isPresent()) {
			todoRepo.delete(todo.get());
			return todo.get();
		} else {
			throw new BaseException("Todo having ID: "+todoId+" not found");
		}
	}
	
	public Todo getTodoByIdFromDb(int todoId) {
		Optional<Todo> todo = todoRepo.findById(todoId);
		if(todo.isPresent()) {
			return todo.get();
		} else {
			throw new BaseException("Todo having ID: "+todoId+" not found");
		}
	}
	
	public List<Todo> getTodosByCompletedStatus(boolean status) {
		
		return todoRepo.findByCompleted(status);
	}
	
	
}
