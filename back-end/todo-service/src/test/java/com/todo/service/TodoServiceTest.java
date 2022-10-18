package com.todo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.todo.entity.Todo;


import java.util.ArrayList;
import java.util.List;




@SpringBootTest
public class TodoServiceTest {
	
		@Autowired
		private   TodoService todoService;
	
		private static List<Todo> todosStub;
		
		@BeforeEach
		public  void init() {
			
			todosStub = new ArrayList<>();
					todosStub.add(new Todo(1, "Play Video Games", false, "11 October 2022"));
					todosStub.add(new Todo(2, "Play Outdoor Games", false, "11 October 2022"));
					todosStub.add(new Todo(3, "Complete Spring Boot", false, "13 October 2022"));
					todosStub.forEach(todo -> todoService.saveTodoToDb(todo));

		}
		@Test
		public void testServiceSaveTodo() {
			
			Todo todo = new Todo(4, "Play Video Games", false, "11 October 2022");
			
			Todo savedTodo = todoService.saveTodoToDb(todo);
			assertEquals(todo.getTask(),savedTodo.getTask());
			assertEquals(4,todoService.getAllTodosFromDb().size());
			
	
		
		}
		
		@Test
		public void testTodoServiceGetTodos() {
			
			assertEquals(4,todoService.getAllTodosFromDb().size());
		
		}
		
		
		@Test
		public void testgetTodoByIdFromDb() {
			Todo todo = todoService.getTodoByIdFromDb(1);
			assertNotNull(todo);
			assertEquals(1,todo.getTodoId());
			assertEquals("Play Video Games",todo.getTask());
			assertEquals(false,todo.isCompleted());
			assertEquals("11 October 2022",todo.getCreatedAt());
		}
		
		
		@Test
		public void testremoveTodoFromDb() {
			todoService.removeTodoFromDb(1);
			assertEquals(3,todoService.getAllTodosFromDb().size());
		}
		
		@Test
		public void testupdateTodoInDb() {
			Todo todo = new Todo(4, "Learn React JS", false, "11 October 2022");
			todoService.updateTodoInDb(todo);
			Todo updatedTodo = todoService.getTodoByIdFromDb(4);
			assertEquals("Learn React JS",updatedTodo.getTask());
		}
		
		
}
