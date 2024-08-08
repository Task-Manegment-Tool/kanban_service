package com.blue.Kanban_service.service;

import com.blue.Kanban_service.client.ProjectService;
import com.blue.Kanban_service.client.TaskService;
import com.blue.Kanban_service.dto.Project;

import com.blue.Kanban_service.dto.Task;
import com.blue.Kanban_service.dto.TaskStatus;
import com.blue.Kanban_service.exception.ProjectNotFoundByProjectIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KanbanServiceImpl implements KanbanService {



    @Autowired
    private ProjectService projectService;

    @Autowired
    private TaskService taskService;

    @Override
    public Project getKanbanBoardByProjectId(Integer id) throws Exception {
        Project project = new Project();

        Optional<Project> optionalProject;
        try {
            optionalProject = Optional.ofNullable(projectService.getProjectById(id).getBody());
        } catch (Exception e) {
            throw new ProjectNotFoundByProjectIdException("project with this id not present into the database");
        }
        project = optionalProject.get();
        return project;
    }



//    @Override
//    public Project getKanbanBoardByProjectId(long id) {
//        return null;
//    }

    @Override
    public String updateTaskStatus(long id, Task task) throws Exception {
//        long id =1;
        System.out.println("inside update task   :  "+id);
        Task fonudTask = taskService.getTaskByTaskId(id).getBody();
//        Task fonudTask = taskStatusRepository.findById(id).orElseThrow(()->new RuntimeException("Task not found"));

        System.out.println(fonudTask);
        if(fonudTask.getStatus() == TaskStatus.BACK_LOG  &&  task.getStatus()==TaskStatus.TO_DO ){
            fonudTask.setStatus(task.getStatus());
           String updateTaskResponse =  taskService.updateTaskStatusById(id,fonudTask).getBody();
//            taskStatusRepository.save(fonudTask);
            return  updateTaskResponse;


        }
        else if(fonudTask.getStatus() == TaskStatus.TO_DO  &&  task.getStatus()==TaskStatus.IN_PROGRESS ){
            fonudTask.setStatus(task.getStatus());
            String updateTaskResponse =  taskService.updateTaskStatusById(id,fonudTask).getBody();
//            taskStatusRepository.save(fonudTask);
            return  updateTaskResponse;
        }
        else if(fonudTask.getStatus() == TaskStatus.IN_PROGRESS  &&  task.getStatus()==TaskStatus.DONE ){
            fonudTask.setStatus(task.getStatus());
            String updateTaskResponse =  taskService.updateTaskStatusById(id,fonudTask).getBody();
//            taskStatusRepository.save(fonudTask);
            return  updateTaskResponse;

        } else if
        ((fonudTask.getStatus() == TaskStatus.DONE  &&  task.getStatus()==TaskStatus.TO_DO)
        || (fonudTask.getStatus() == TaskStatus.DONE  &&  task.getStatus()==TaskStatus.IN_PROGRESS)
        || (fonudTask.getStatus() == TaskStatus.DONE  &&  task.getStatus()==TaskStatus.BACK_LOG)){

            fonudTask.setDescription("status u given is invalid");
            Exception e = new RuntimeException("invalid status update");
//            throw e;
            return e.getMessage();

        }
        else {

//            fonudTask.setDescription("status u given is invalid");
            Exception e = new RuntimeException("invalid status update");
            return e.getMessage();


        }

//        return "Something goes wrong";
    }

//    @Override
//    public Project createProject(Project project) {
////        Project creteProject =kanbanRepository.save(project);
//
//        return project;
//    }
//
//    @Override
//    public Task
//    createTask(Task task) {
//        Task createTask = taskStatusRepository.save(task);
//    return  createTask;
//    }
}
