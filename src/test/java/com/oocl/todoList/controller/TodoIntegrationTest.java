package com.oocl.todoList.controller;


import com.oocl.todoList.entity.Todo;
import com.oocl.todoList.repository.TodoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TodoIntegrationTest {
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private MockMvc mockMvc;

    private Integer todoId;

    @BeforeEach
    public void before() {
        todoId = todoRepository.save(new Todo(1, "hello", true)).getId();
        todoRepository.save(new Todo(1, "hello", true));
    }

    @AfterEach
    public void after() {
        todoRepository.deleteAll();
        assert todoRepository.findAll().isEmpty();
    }

    @Test
    public void should_return_todos_when_get_todos_given_none() throws Exception {
        //when then
        mockMvc.perform(get("/todos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(todoId))
                .andExpect(jsonPath("$[0].content").value("hello"));
    }

    @Test
    public void should_return_todo_when_add_todo_given_todo() throws Exception {
        //when then
        mockMvc.perform(post("/todos")
                .contentType(MediaType.APPLICATION_JSON).content("{\n" +
                        "    \"content\":\"hello\"\n" +
                        "}"))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.content").value("hello"));
    }

    @Test
    public void should_return_todo_when_update_todo_given_todo() throws Exception {
        //when then
        mockMvc.perform(post("/todos/" + this.todoId)
                .contentType(MediaType.APPLICATION_JSON).content("{\n" +
                        "    \"status\":\"true\"\n" +
                        "}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(true));
    }
}
