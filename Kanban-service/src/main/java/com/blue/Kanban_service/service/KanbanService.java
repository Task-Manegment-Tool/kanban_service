package com.blue.Kanban_service.service;

import com.blue.Kanban_service.dto.Project;
import com.blue.Kanban_service.dto.Task;
import org.springframework.stereotype.Service;

@Service
public interface KanbanService {

    public Project getKanbanBoardByProjectId(Integer id) throws Exception;
    public String updateTaskStatus(long id , Task task) throws Exception;
//    public Project  createProject(Project project);
//    public Task createTask(Task task);
//


}
