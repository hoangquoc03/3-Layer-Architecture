package com.example.demo.controllers;

import com.example.demo.models.Task;
import com.example.demo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(
            @RequestParam(required = false) String search) {

        List<Task> tasks = taskService.findAllTasks();

        // Nếu có search thì filter
        if (search != null && !search.isEmpty()) {

            tasks = tasks.stream()
                    .filter(task ->
                            task.getTitle()
                                    .toLowerCase()
                                    .contains(search.toLowerCase()))
                    .collect(Collectors.toList());
        }

        return ResponseEntity.ok(tasks);
    }
}