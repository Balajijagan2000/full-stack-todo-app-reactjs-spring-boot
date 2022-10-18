package com.todo.controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.todo.entity.Todo;
import com.todo.service.TodoService;



/*Static imports for http methods*/
import  static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import  static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import  static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import  static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

//imports for webmvc tests
import  static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import  static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class TodoControllerTest {

	@Autowired
	 private WebApplicationContext wac;
	

	//MockMvc is used to perform testing on 
	//rest api's at controller layer
	private  MockMvc mvc;


	

	private ObjectMapper mapper = new ObjectMapper();
	
	@MockBean
	private TodoService serviceMock;
	
	private static List<Todo> todosStub;
	static {
		todosStub = new ArrayList<>();
		todosStub.add(new Todo(1, "Play Video Games", false, "11 October 2022"));
		todosStub.add(new Todo(2, "Play Outdoor Games", false, "11 October 2022"));
		todosStub.add(new Todo(3, "Complete Spring Boot", false, "13 October 2022"));
	}
	
	@BeforeEach
	public  void init() {
		this.mvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}
	

	@Test
	public void testGetAllTodo() throws Exception {
		
		
		
		this.mvc.perform(get("/todos"))
		.andExpect(status().isOk());

	}
	
	@Test
	public void testGetTodoById() throws Exception {
		
		
		this.mvc.perform(get("/todos/1"))
		.andExpect(status().isOk());
		

	}
	
	@Test
	public void testPostRequest() throws Exception {
		
		Todo todo = new Todo(1, "Play Video Games", false, "2022-10-11");
		
		 mvc.perform(
			      post("/todos")
			      .content(mapper.writeValueAsString(todo))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isCreated())
			      .andDo(print());
		
		
	}
	
	
	@Test
	public void testPutRequest() throws Exception {
		
		Todo todo = new Todo(1, "Play Video Games", false, "2022-10-11");
		 mvc.perform(
			      post("/todos")
			      .content(mapper.writeValueAsString(todo))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isCreated());
		Todo todo_new = new Todo(1, "Study", false, "2022-10-11");
		
		 mvc.perform(
			      put("/todos/update")
			      .content(mapper.writeValueAsString(todo_new))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isCreated())
			      .andDo(print());
		
		
	}
	
	
	@Test
	public void testDeleteRequest() throws Exception {
		
	
		Todo todo = new Todo(1, "Play Video Games", false, "2022-10-11");
		 mvc.perform(
			      post("/todos")
			      .content(mapper.writeValueAsString(todo))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isCreated());
		
		 mvc.perform(
			      delete("/todos/1")
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andDo(print());
		
		
	}
	


	
}
