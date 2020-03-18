package com.mitrais.todo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mitrais.todo.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{
	Course findByCourseId(int courseId);
	List<Course> findAll();
	
	@Transactional
	@Modifying
	@Query(value="Delete from Course u WHERE u.courseId = :courseId")
	int deleteCourseByCourseId(@Param("courseId") int courseId);
	
	@Query(value = "SELECT c FROM Course c WHERE c.courseType = :courseType")
	List<Course> findAllByCourseType(@Param("courseType") String courseType);


}
