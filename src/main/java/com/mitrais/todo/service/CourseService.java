package com.mitrais.todo.service;

import java.util.List;

import com.mitrais.todo.model.Course;

public interface CourseService {
	void createCourse(Course course);
	Course getCourseById(int courseId);
	List<Course> getAllCourse();
	int deleteByCourseId(int courseId);
	List<Course> getCourseByCourseType(String courseType);
}
