package com.oocl.todolist.service;

import com.oocl.todolist.entity.Todo;
import com.oocl.todolist.exception.NotFoundException;

import java.util.List;

/**
 * @author XUAL7
 */
public interface TodoService {
    List<Todo> getTodos();

    Todo updateTodo(Integer id, Todo todo) throws NotFoundException;

    Boolean deleteTodo(Integer id) throws NotFoundException;

    Todo addTodo(Todo todo);
}
