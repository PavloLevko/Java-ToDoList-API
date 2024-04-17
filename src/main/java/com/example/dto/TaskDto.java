package com.example.dto;

import com.example.domain.Status;
import lombok.Data;

@Data
public class TaskDto {
    private Long id;
    private String description;
    private Status status;
}
