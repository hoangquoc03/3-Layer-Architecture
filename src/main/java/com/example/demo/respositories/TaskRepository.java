package com.example.demo.respositories;

import com.example.demo.models.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {

    private List<Task> tasks = new ArrayList<>();

    public TaskRepository() {

        tasks.add(new Task(1, "Fix Login", "Fix login bug", "HIGH", 1L));
        tasks.add(new Task(2, "Create API", "Build user API", "MEDIUM", 1L));
        tasks.add(new Task(3, "Testing", "Write unit test", "LOW", 2L));
        tasks.add(new Task(4, "Deploy App", "Deploy to server", "HIGH", 2L));
        tasks.add(new Task(5, "UI Design", "Create homepage", "LOW", 3L));
        tasks.add(new Task(6, "Security", "Add JWT", "HIGH", 1L));
        tasks.add(new Task(7, "Database", "Design schema", "MEDIUM", 2L));
        tasks.add(new Task(8, "Optimize", "Improve performance", "MEDIUM", 3L));
        tasks.add(new Task(9, "Bug Fix", "Fix API issue", "LOW", 1L));
        tasks.add(new Task(10, "Document", "Write API docs", "MEDIUM", 3L));
    }

    public List<Task> findAll() {
        return tasks;
    }
    public void save(Task task){
        tasks.add(task);
    }
}