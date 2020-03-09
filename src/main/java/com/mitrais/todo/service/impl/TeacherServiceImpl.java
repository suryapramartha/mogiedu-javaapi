package com.mitrais.todo.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitrais.todo.model.Teacher;
import com.mitrais.todo.repository.TeacherRepository;
import com.mitrais.todo.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherRepository teacherRepository;

	@Override
	public void createTeacher(Teacher teacher) {
		this.teacherRepository.save(teacher);
	}

	@Override
	public int deleteByTeacherId(int teacherId) {
		
		return this.teacherRepository.deleteTeacherByTeacherId(teacherId);
	}

	@Override
	public Teacher getTeacherById(int teacherId) {
		return this.teacherRepository.findByTeacherId(teacherId);
	}

	@Override
	public List<Teacher> getAllTeacher() {
		return this.teacherRepository.findAll();
	}

}
