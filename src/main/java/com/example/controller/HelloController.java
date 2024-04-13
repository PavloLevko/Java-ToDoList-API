package com.example.controller;
import com.example.domain.Task;
import com.example.service.TaskService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/tasks")
public class HelloController {
  private final   TaskService taskService;
    @GetMapping
    public List<Task> hello(){
        System.out.println("Server start");
        System.out.println(taskService.getAll());
        return taskService.getAll();
    }

    @PostMapping(value = "/task")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTask(@RequestBody Task task){
       taskService.saveTask(task);
    }
    @GetMapping(value = "/task/{taskId}")
    public Task getTaskById (@PathVariable Long taskId){
        return taskService.getTaskById(taskId);
    }

}
