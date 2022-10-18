package com.todo.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TodoEntityTest {
		
		private static Todo todoStub;
		
		
		

		@BeforeAll
		public static void init() {
			
			todoStub = new Todo(1, "Play Video Games", false, "11 October 2022");
			
		}
		
		
		@Test 
		public void testGettersAndSetters() {
			assertEquals(1,todoStub.getTodoId());
			assertFalse(todoStub.isCompleted());
			assertEquals("Play Video Games",todoStub.getTask());
			assertEquals("11 October 2022",todoStub.getCreatedAt());
		}
		
	
	
}
