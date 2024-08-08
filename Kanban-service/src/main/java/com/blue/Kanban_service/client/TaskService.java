package com.blue.Kanban_service.client;

import com.blue.Kanban_service.dto.Task;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "TASK-SERVICE")
public interface TaskService
{
    @PutMapping("/task/taskId/updateStatus/{taskId}")
    public ResponseEntity<String> updateTaskStatusById(@PathVariable("taskId") Long taskId, @RequestBody Task status);

    @GetMapping("/task/taskId/{taskId}")
    public ResponseEntity<Task> getTaskByTaskId(@PathVariable("taskId") Long taskId);
}
