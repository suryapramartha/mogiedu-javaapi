package com.mitrais.todo.controller;

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

import com.mitrais.todo.model.Course;
import com.mitrais.todo.service.CourseService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CourseController {
	@Autowired
	CourseService courseService;
	
	@PostMapping(value="/course" , consumes={"application/json"})
	public ResponseEntity<?> createCourse(@RequestBody Course course) {
		try {
			String courseName = course.getCourseName();
			String courseType = course.getCourseType();
			int coursePriceReg = course.getCoursePriceReg();
			int coursePriceBil = course.getCoursePriceBil();
			String courseLevel = course.getCourseLevel();
			String status = course.getStatus();
			String courseGrade = course.getCourseGrade();
			String courseCategory = course.getCourseCategory();

			if (courseName == null || courseType == null || courseLevel == null || coursePriceReg == 0 || coursePriceBil == 0 ||status == null) {
				return ResponseEntity.badRequest()
						.body(Collections.singletonMap("errorMessage", "data course is invalid"));
			}
			Course newCourse = new Course(courseName, courseType, coursePriceReg, coursePriceBil, courseLevel, courseGrade,courseCategory, status, new Date());
			courseService.createCourse(newCourse);
			return new ResponseEntity<>(newCourse,HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest()
					.body(Collections.singletonMap("errorMessage", "could not execute statement"));
		}
	}
	
	@PutMapping(value="/course" , consumes={"application/json"})
	public ResponseEntity<?> updateCourse(@RequestBody Course course) {
		try {
	        if (course == null) {
				return ResponseEntity.badRequest().body(Collections.singletonMap("errorMessage", "could not execute statement"));
	        }
	        courseService.createCourse(course);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(Collections.singletonMap("errorMessage", "could not execute statement"));
		}
	}
	
	@GetMapping("/course/{courseId}")
	public ResponseEntity<?> getCourseById(@PathVariable("courseId") int courseId) throws Exception {
		try{
			Course course = courseService.getCourseById(courseId);
			if (course == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(course,HttpStatus.OK);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/courses")
	public ResponseEntity<List<?>> getAllCourse() throws Exception {
		try{
			List<Course> course = courseService.getAllCourse();
			if (course == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(course,HttpStatus.OK);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/course/{courseId}")
	public ResponseEntity<?> deleteCourseById(@PathVariable("courseId") int courseId) throws Exception {
		try{
			int course = courseService.deleteByCourseId(courseId);
			if (course == 1) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/courseByType/{courseType}")
	public ResponseEntity<List<?>> getAllCourseByType(@PathVariable("courseType") String courseType) throws Exception {
		try{
			List<Course> course = courseService.getCourseByCourseType(courseType);
			if (course == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(course,HttpStatus.OK);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
