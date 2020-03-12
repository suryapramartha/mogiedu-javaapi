package com.mitrais.todo.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
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

import com.mitrais.todo.model.Teacher;
import com.mitrais.todo.service.TeacherService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	

//	@PostMapping(value="/teacher" , consumes={"application/json"})
//	public ResponseEntity<?> createTeacher(@RequestBody Teacher teacher) {
//		try {
//			String firstName = teacher.getFirstName();
//			String lastName = teacher.getLastName();
//			String email = teacher.getEmail();
//			if (firstName == null || lastName == null || email == null) {
//				return ResponseEntity.badRequest()
//						.body(Collections.singletonMap("errorMessage", "data teacher is invalid"));
//			}
//			Teacher newTeacher = new Teacher(firstName, lastName, email, teacher.getStatus());
//			teacherService.createTeacher(newTeacher);
//			return new ResponseEntity<>(newTeacher,HttpStatus.CREATED);
//		}catch(Exception e) {
//			e.printStackTrace();
//			return ResponseEntity.badRequest()
//					.body(Collections.singletonMap("errorMessage", "could not execute statement"));
//		}
//	}
	
	@PutMapping(value="/teacher" , consumes={"application/json"})
	public ResponseEntity<?> updateTeacher(@RequestBody Teacher teacher) {
		try {
	        if (teacher == null) {
				return ResponseEntity.badRequest().body(Collections.singletonMap("errorMessage", "could not execute statement"));
	        }
	        teacherService.createTeacher(teacher);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(Collections.singletonMap("errorMessage", "could not execute statement"));
		}
	}
	
	@GetMapping("/teacher/{teacherId}")
	public ResponseEntity<?> getTeacherById(@PathVariable("teacherId") int teacherId) throws Exception {
		try{
			Teacher teacher = teacherService.getTeacherById(teacherId);
			if (teacher == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(teacher,HttpStatus.OK);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/teacherByUsername/{username}")
	public ResponseEntity<?> getTeacherByUsername(@PathVariable("username") String username) throws Exception {
		try{
			Teacher teacher = teacherService.getTeacherByUsername(username);
			if (teacher == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(teacher,HttpStatus.OK);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/teachers")
	public ResponseEntity<List<?>> getAllTeacher() throws Exception {
		try{
			List<Teacher> teacher = teacherService.getAllTeacher();
			if (teacher == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(teacher,HttpStatus.OK);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/teacher/{teacherId}")
	public ResponseEntity<?> deleteTodoById(@PathVariable("teacherId") int teacherId) throws Exception {
		try{
			int teacher = teacherService.deleteByTeacherId(teacherId);
			if (teacher == 1) {
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
