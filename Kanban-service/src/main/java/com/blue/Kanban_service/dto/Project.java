package com.blue.Kanban_service.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class Project {
        private Integer id;
        private String projectName;
        private String client;
        private String domain;
        private LocalDate startDate;
        private  Long userId;

        private List<Task> taskList;
    }

