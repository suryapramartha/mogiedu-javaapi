package com.mitrais.todo.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitrais.todo.model.Todo;
import com.mitrais.todo.service.TodoService;
import com.temporary.configurationWithH2.JwtUserDetails;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TodoController {

	@Autowired
	private TodoService todoService;

	/*create new Todo*/
	@PostMapping(value="/todos" , consumes={"application/json"})
	public ResponseEntity<?> createTodo(@RequestBody Todo todo) {
		try {
			String userId = todo.getUserId();
			String desc = todo.getDescription();
			String targetDate = todo.getTargetDate();
			String status = todo.getStatus();
			if (userId == null || desc == null || targetDate == null || status == null) {
				return ResponseEntity.badRequest()
						.body(Collections.singletonMap("errorMessage", "data parameter is invalid"));
			}
			todoService.createTodo(todo);
			return new ResponseEntity<>(todo,HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest()
					.body(Collections.singletonMap("errorMessage", "could not execute statement"));
		}
	}
	
	@PutMapping(value="/todos" , consumes={"application/json"})
	public ResponseEntity<?> updateTodo(@RequestBody Todo todo) {
		try {
			String userId = todo.getUserId();
			String desc = todo.getDescription();
			String targetDate = todo.getTargetDate();
			String status = todo.getStatus();
			if (userId == null || desc == null || targetDate == null || status == null) {
				return ResponseEntity.badRequest().body(Collections.singletonMap("errorMessage", "data parameter is invalid"));
			}
			Todo a = todoService.getTodoIdByUsername(userId, todo.getTodoId());
			if(a == null) {
				return ResponseEntity.badRequest().body(Collections.singletonMap("errorMessage", "data not found"));
			}
			todoService.createTodo(todo);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(Collections.singletonMap("errorMessage", "could not execute statement"));
		}
	}
	
	@GetMapping("/basic-auth")
	public ResponseEntity<?> basicAuth() {
		return ResponseEntity.ok().body(Collections.singletonMap("message", "OK"));

	}
	
	@GetMapping("/todos/{username}")
	public ResponseEntity<List<?>> getTodoByUsername(@PathVariable("username") String username) throws Exception {
		try{
			List<Todo> todo = todoService.getTodoByUsername(username);
			if (todo.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(todo,HttpStatus.OK);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/todos/{username}/{todoId}")
	public ResponseEntity<?> getTodoIdByUsername(@PathVariable("username") String username, @PathVariable("todoId") int todoId) throws Exception {
		try{
			Todo todo = todoService.getTodoIdByUsername(username, todoId);
			if (todo.equals(null)) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(todo,HttpStatus.OK);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/todos/{username}/{todoId}")
	public ResponseEntity<?> deleteTodoByUsername(@PathVariable("username") String username, @PathVariable("todoId") int todoId) throws Exception {
		try{
			int todo = todoService.deleteById(username, todoId);
			if (todo == 1) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
