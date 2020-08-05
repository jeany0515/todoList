package com.oocl.todoList.service;

import com.oocl.todoList.entity.Todo;
import com.oocl.todoList.exception.NotFoundException;
import com.oocl.todoList.repository.TodoRepository;
import com.oocl.todoList.service.impl.TodoServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class TodoServiceTest {
    @Test
    public void should_return_list_of_todo_when_get_todos_given_none() {
        //given
        TodoRepository repository = mock(TodoRepository.class);
        List<Todo> todos = new ArrayList<>();
        todos.add(new Todo());
        todos.add(new Todo());
        TodoService todoService = new TodoServiceImpl(repository);
        given(repository.findAll()).willReturn(todos);
        //when
        List<Todo> todosSaved = todoService.getTodos();
        //then
        assertIterableEquals(todos, todosSaved);
    }

    @Test
    public void should_return_todo_when_update_todo_given_todo() throws NotFoundException {
        //given
        TodoRepository repository = mock(TodoRepository.class);
        Todo todo = new Todo(1, "123", true);
        TodoService todoService = new TodoServiceImpl(repository);
        given(repository.save(any(Todo.class))).willReturn(todo);
        given(repository.findById(anyInt())).willReturn(Optional.of(new Todo()));
        //when
        Todo todoSaved = todoService.updateTodo(todo.getId(), todo);
        //then
        assertEquals(todo, todoSaved);
    }

    @Test
    public void should_return_true_when_delete_todo_given_id() throws NotFoundException {
        //given
        TodoRepository repository = mock(TodoRepository.class);
        TodoService todoService = new TodoServiceImpl(repository);
        given(repository.findById(anyInt())).willReturn(Optional.of(new Todo()));
        //when
        Boolean success = todoService.deleteTodo(1);
        //then
        assertTrue(success);
    }
}
