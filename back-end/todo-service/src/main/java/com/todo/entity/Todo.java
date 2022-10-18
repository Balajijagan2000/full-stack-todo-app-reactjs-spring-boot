package com.todo.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int todoId;
	private String task;
	private boolean completed;
	private String createdAt;
	
	
	public Todo() {
		
	}

	
	public Todo(int todoId, String task, boolean completed, String createdAt) {
		super();
		this.todoId = todoId;
		this.task = task;
		this.completed = completed;
		this.createdAt = createdAt;
	}


	public int getTodoId() {
		return todoId;
	}


	public void setTodoId(int todoId) {
		this.todoId = todoId;
	}


	public String getTask() {
		return task;
	}


	public void setTask(String task) {
		this.task = task;
	}


	public boolean isCompleted() {
		return completed;
	}


	public void setCompleted(boolean completed) {
		this.completed = completed;
	}


	public String getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}


	

	
	
	
	
	
	
	
	
}
