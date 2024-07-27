package com.blue.Kanban_service.repository;

//import com.blue.Kanban_service.entity.Kanban;
import com.blue.Kanban_service.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KanbanRepository extends JpaRepository<Project,Long> {


}
