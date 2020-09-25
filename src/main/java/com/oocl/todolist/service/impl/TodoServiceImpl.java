package com.oocl.todolist.service.impl;

import com.oocl.todolist.entity.Todo;
import com.oocl.todolist.exception.NotFoundException;
import com.oocl.todolist.repository.TodoRepository;
import com.oocl.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author XUAL7
 */
@Service
public class TodoServiceImpl implements TodoService {

    public static final String TODO_NOT_FOUND = "todo not found";
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
    public Todo updateTodo(Integer id, Todo todo) throws NotFoundException {
        if (isTodoExisted(id)) {
            throw new NotFoundException(TODO_NOT_FOUND);
        }
        todo.setId(id);
        return todoRepository.save(todo);
    }

    @Override
    public Boolean deleteTodo(Integer id) throws NotFoundException {
        if (isTodoExisted(id)) {
            throw new NotFoundException(TODO_NOT_FOUND);
        }
        todoRepository.deleteById(id);
        return true;
    }

    @Override
    public Todo addTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public boolean isTodoExisted(Integer id) {
        return !todoRepository.findById(id).isPresent();
    }
}
