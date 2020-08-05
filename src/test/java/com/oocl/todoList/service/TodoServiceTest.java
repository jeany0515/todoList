package com.oocl.todoList.service;

import com.oocl.todoList.entity.Todo;
import com.oocl.todoList.repository.TodoRepository;
import com.oocl.todoList.service.impl.TodoServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
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
}
