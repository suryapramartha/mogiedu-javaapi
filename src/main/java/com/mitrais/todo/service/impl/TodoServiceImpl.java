package com.mitrais.todo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitrais.todo.model.Todo;
import com.mitrais.todo.repository.TodoRepository;
import com.mitrais.todo.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoRepository todoRepository;
	
	@Override
	public void createTodo(Todo todo) {
		todoRepository.save(todo);
	}

	@Override
	public List<Todo> getTodoByUsername(String username) {
		return this.todoRepository.findByUserId(username);
	}

	@Override
	public int deleteById(String username, int todoId) {
		return this.todoRepository.deleteTodoByUserId(todoId, username);
	}

	@Override
	public Todo getTodoIdByUsername(String username, int todoId) {
		return this.todoRepository.findByTodoIdAndUserId(username, todoId);
	}


}
