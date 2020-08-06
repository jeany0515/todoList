package com.oocl.todoList.controller;

import com.oocl.todoList.entity.Todo;
import com.oocl.todoList.exception.NotFoundException;
import com.oocl.todoList.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author XUAL7
 */
@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getTodo() {
        return todoService.getTodos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Integer id, @RequestBody Todo todo) throws NotFoundException {
        return todoService.updateTodo(id, todo);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Integer id) throws NotFoundException {
        todoService.deleteTodo(id);
    }
}
