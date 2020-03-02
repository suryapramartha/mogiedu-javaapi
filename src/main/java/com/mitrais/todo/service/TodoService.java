package com.mitrais.todo.service;

import java.util.List;

import com.mitrais.todo.model.Todo;

public interface TodoService {

	void createTodo(Todo todo);
	List<Todo> getTodoByUsername(String username); 
	Todo getTodoIdByUsername(String username, int todoId); 
	int deleteById(String username, int todoId);

}
