package com.example.service;

import com.example.domain.Task;
import com.example.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TaskService {
   private final TaskRepository taskRepository;
    ModelMapper mapper;

@Transactional
    public List<Task> getAll(){
        return taskRepository.getAllTasks().stream()
                .map(t -> mapper.map(t, Task.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public void saveTask(Task task){
    taskRepository.saveTask(mapper.map(task, Task.class));
    }
    @Transactional
    public Task getTaskById(Long id){
   return mapper.map(taskRepository.getById(id),Task.class);
    }
}