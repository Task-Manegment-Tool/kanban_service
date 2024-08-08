package com.blue.Kanban_service.exception;

public class ProjectNotFoundByProjectIdException extends RuntimeException{
    public ProjectNotFoundByProjectIdException(String message) {
        super(message);
    }
}
