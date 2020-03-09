package com.mitrais.todo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitrais.todo.model.Course;
import com.mitrais.todo.repository.CourseRepository;
import com.mitrais.todo.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	CourseRepository courseRepository;

	@Override
	public void createCourse(Course course) {
		this.courseRepository.save(course);
	}

	@Override
	public Course getCourseById(int courseId) {
		return this.courseRepository.findByCourseId(courseId);
	}

	@Override
	public List<Course> getAllCourse() {
		return this.courseRepository.findAll();
	}

	@Override
	public int deleteByCourseId(int courseId) {
		return this.courseRepository.deleteCourseByCourseId(courseId);
	}

}
