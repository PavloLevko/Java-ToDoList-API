package com.example.controller;
import com.example.service.TaskService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Data
@Controller
@RequestMapping("/hello")
public class HelloController {
  private final   TaskService taskService;
    @GetMapping
    public List hello(){
        System.out.println("Server start");

        return taskService.getAll();
    }
}
