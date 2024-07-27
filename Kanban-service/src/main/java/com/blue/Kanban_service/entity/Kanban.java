//package com.blue.Kanban_service.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class Kanban {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;  //project ID
//    private String name; //project Name
//
//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "taskstatus_id")
//    private List<TaskStatus> taskStatus;
//
//}
