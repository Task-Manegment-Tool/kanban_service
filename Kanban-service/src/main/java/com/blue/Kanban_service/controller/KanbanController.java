package com.blue.Kanban_service.controller;

import com.blue.Kanban_service.dto.Project;
import com.blue.Kanban_service.dto.Task;
//import com.blue.Kanban_service.repository.KanbanRepository;
import com.blue.Kanban_service.service.KanbanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kanban")
public class KanbanController {

    @Autowired
    private KanbanService kanbanService;

//    @Autowired
//    private KanbanRepository kanbanRepository;

//    @GetMapping
//    public ResponseEntity<List<Project>> getProject (){
//
//        return  ResponseEntity.ok( kanbanRepository.findAll());
//    }

    @GetMapping("/getKanbanBoardByProjectID/{projectId}")
    public ResponseEntity<Project> getKanbanBoardByProjectID(@PathVariable Integer projectId) throws Exception {
        Project project= kanbanService.getKanbanBoardByProjectId(projectId);

        return  ResponseEntity.ok(project);
    }

    @PostMapping("/updateTaskStatus/{taskId}")
    public ResponseEntity<String> updateTaskStatus(@PathVariable Long taskId,@RequestBody Task task) throws Exception {
        System.out.println(taskId);
        System.out.println(task);
        String updateTask= kanbanService.updateTaskStatus(taskId,task);

        return  ResponseEntity.ok(updateTask);
    }
//    @PostMapping("/createProject")
//    public ResponseEntity<com.blue.Kanban_service.dto.Project> createProject(@RequestBody Project project){
//        for (Task task : project.getTaskList()){
//            task.setProject(project);
//        }
////        Project cratedProject= kanbanService.createProject(project);
//
//        return  ResponseEntity.ok(cratedProject);
//    }
//    @PostMapping("/createTask/project/{projectId}")
//    public ResponseEntity<Task> createTask(@PathVariable Long projectId,@RequestBody Task task){
//        Project project = kanbanRepository.findById(projectId).orElseThrow(()->new RuntimeException("project not found"));
//        task.setProject(project);
//        Task cratedTask= kanbanService.createTask(task);
//
//        return  ResponseEntity.ok(cratedTask);
//    }

}
