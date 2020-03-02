package com.mitrais.todo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mitrais.todo.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer>{

	List<Todo> findByUserId(String userId);
	
	@Query(value="SELECT u FROM Todo u WHERE u.todoId = :todoId and u.userId = :userId")
	Todo findByTodoIdAndUserId(@Param("userId") String userId, @Param("todoId") int todoId);
	
	@Transactional
	@Modifying
	@Query(value="Delete from Todo u WHERE u.todoId = :todoId and u.userId= :userId")
	int deleteTodoByUserId(@Param("todoId") int todoId, @Param("userId") String userId);
	
}
