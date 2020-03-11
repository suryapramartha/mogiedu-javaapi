package com.mitrais.todo.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mitrais.todo.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer>{

	Teacher findByTeacherId(int teacherId);
	Teacher findByUsername(String username);
	List<Teacher> findAll();
	
	@Transactional
	@Modifying
	@Query(value="Delete from Teacher u WHERE u.teacherId = :teacherId")
	int deleteTeacherByTeacherId(@Param("teacherId") int teacherId);
}
