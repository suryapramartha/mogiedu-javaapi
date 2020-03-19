package com.mitrais.todo.service;


import java.util.List;

import com.mitrais.todo.model.Teacher;


public interface TeacherService {
	void createTeacher(Teacher teacher);
	Teacher getTeacherById(int teacherId);
	Teacher getTeacherByUsername(String username);
	List<Teacher> getAllTeacher();
	int deleteByTeacherId(int teacherId);
	List<Teacher> getTeacherWithLimit(int limit);

}
