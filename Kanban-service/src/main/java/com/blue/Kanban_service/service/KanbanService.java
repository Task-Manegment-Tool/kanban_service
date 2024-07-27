package com.blue.Kanban_service.service;

//import com.blue.Kanban_service.entity.TaskStatus;
import com.blue.Kanban_service.entity.Project;
import com.blue.Kanban_service.entity.Task;
import org.springframework.stereotype.Service;

@Service
public interface KanbanService {

    public Project getKanbanBoardByProjectId(long id);
    public String updateTaskStatus(long id , Task task) throws Exception;
    public Project  createProject(Project project);
    public Task  createTask(Task task);



}
