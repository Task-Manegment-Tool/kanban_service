package com.blue.Kanban_service.exceptions_handler_controllers;

import com.blue.Kanban_service.exception.ProjectNotFoundByProjectIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionHandlerController {
    @ExceptionHandler(ProjectNotFoundByProjectIdException.class)
    public ResponseEntity<String> handleProjectExceptionHandlerController(ProjectNotFoundByProjectIdException projectNotFoundByProjectIdException) {
        return new ResponseEntity<>(projectNotFoundByProjectIdException.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
