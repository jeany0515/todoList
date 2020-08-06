package com.oocl.todoList.controller;

import com.oocl.todoList.exception.NotFoundException;
import dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author XUAL7
 */
@ControllerAdvice
@ResponseBody
public class TodoExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse notFoundException(NotFoundException exception) {
        return new ErrorResponse(404, exception.getMessage());
    }
}
