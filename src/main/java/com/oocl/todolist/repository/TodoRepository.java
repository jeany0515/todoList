package com.oocl.todolist.repository;

import com.oocl.todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author XUAL7
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
