package com.oocl.todoList.controller;

import com.oocl.todoList.exception.NotFoundException;
import com.oocl.todoList.repository.TodoRepository;
import com.oocl.todoList.service.TodoService;
import com.oocl.todoList.service.impl.TodoServiceImpl;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class TodoExceptionHandler {
    @Test
    public void should_return_not_found_exception_when_find_by_id_given_id() {
        //given
        Integer id = 1;
        TodoRepository todoRepository = mock(TodoRepository.class);
        TodoService todoService = new TodoServiceImpl(todoRepository);
        given(todoRepository.findById(anyInt())).willReturn(Optional.empty());
        //when
        Exception notFoundException = assertThrows(NotFoundException.class, () -> todoService.deleteTodo(id));
        //then
        assertEquals(NotFoundException.class, notFoundException.getClass());
    }
}
