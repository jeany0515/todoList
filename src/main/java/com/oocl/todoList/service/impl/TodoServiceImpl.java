package com.oocl.todoList.service.impl;

import com.oocl.todoList.entity.Todo;
import com.oocl.todoList.repository.TodoRepository;
import com.oocl.todoList.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author XUAL7
 */
@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Todo updateTodo(Integer id, Todo todo) {
        return null;
    }

    @Override
    public Boolean deleteTodo(Integer id) {
        return null;
    }

    @Override
    public Todo addTodo(Todo todo) {
        return null;
    }
}
