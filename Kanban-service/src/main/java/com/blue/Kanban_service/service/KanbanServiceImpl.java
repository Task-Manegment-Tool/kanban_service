package com.blue.Kanban_service.service;

import com.blue.Kanban_service.entity.Project;
import com.blue.Kanban_service.entity.Task;
import com.blue.Kanban_service.entity.TaskStatus;
import com.blue.Kanban_service.repository.KanbanRepository;
import com.blue.Kanban_service.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KanbanServiceImpl implements KanbanService {


    @Autowired
    private KanbanRepository kanbanRepository;
    @Autowired
    private TaskRepository taskStatusRepository;

    @Override
    public Project getKanbanBoardByProjectId(long id) {
//        long pid = 2;
        Project project = kanbanRepository.findById(id).get();
        return  project;
    }

    @Override
    public String updateTaskStatus(long id, Task task) throws Exception {
//        long id =1;
        System.out.println("inside update task   :  "+id);
        Task fonudTask = taskStatusRepository.findById(id).orElseThrow(()->new RuntimeException("Task not found"));


        if(fonudTask.getStatus() == TaskStatus.BACK_LOG  &&  task.getStatus()==TaskStatus.TO_DO ){
            fonudTask.setStatus(task.getStatus());
            taskStatusRepository.save(fonudTask);


        }
        else if(fonudTask.getStatus() == TaskStatus.TO_DO  &&  task.getStatus()==TaskStatus.IN_PROGRESS ){
            fonudTask.setStatus(task.getStatus());
            taskStatusRepository.save(fonudTask);

        }
        else if(fonudTask.getStatus() == TaskStatus.IN_PROGRESS  &&  task.getStatus()==TaskStatus.DONE ){
            fonudTask.setStatus(task.getStatus());
            taskStatusRepository.save(fonudTask);

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

        return "Status Update ";
    }

    @Override
    public Project createProject(Project project) {
        Project creteProject =kanbanRepository.save(project);

        return creteProject;
    }

    @Override
    public Task createTask(Task task) {
        Task createTask = taskStatusRepository.save(task);
    return  createTask;
    }
}
