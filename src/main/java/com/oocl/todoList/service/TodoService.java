package com.oocl.todoList.service;

import com.oocl.todoList.entity.Todo;

import java.util.List;

/**
 * @author XUAL7
 */
public interface TodoService {
    List<Todo> getTodos();

    Todo updateTodo(Integer id, Todo todo);

    Boolean deleteTodo(Integer id);

    Todo addTodo(Todo todo);
}
