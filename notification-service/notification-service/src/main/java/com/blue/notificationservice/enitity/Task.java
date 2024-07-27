package com.blue.notificationservice.enitity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Task {

    private Long taskId;
    private String name;
    private String description;
    private LocalDateTime expiryTime;
    private Long userId;
    private  String status;
}
