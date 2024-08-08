package com.blue.Kanban_service.client;

import com.blue.Kanban_service.dto.Project;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PROJECT-SERVICE")
public interface ProjectService {

    @GetMapping(value = "/project/getProjectById/{projectId}")
     ResponseEntity<Project> getProjectById(@PathVariable("projectId") Integer projectId) throws  Exception;
}
