package com.example.service;

import com.example.domain.Task;
import com.example.repository.TaskRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class TaskService {
    TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAll(){
        System.out.println(taskRepository.getAllTasks());
        return taskRepository.getAllTasks();

    }
}
