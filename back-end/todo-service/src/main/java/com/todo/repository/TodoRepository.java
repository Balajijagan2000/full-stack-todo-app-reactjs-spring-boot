package com.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Integer>{

	public List<Todo> findByCompleted(boolean completed);
}
