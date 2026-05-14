package com.example.demo.services;

import com.example.demo.models.Task;
import com.example.demo.models.User;
import com.example.demo.respositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserService userService;

    @Autowired
    public TaskService(TaskRepository taskRepository, UserService userService){
        this.taskRepository = taskRepository;
        this.userService = userService;
    }
    public List<Task> findAllTasks(){
        return taskRepository.findAll();
    }
    public boolean createTask(Task newTask) {

        // Kiểm tra assignedTo có tồn tại không
        User user =
                userService.findUserById(newTask.getAssignedTo());

        // Không tìm thấy user
        if (user == null) {
            return false;
        }

        // Có user → lưu task
        taskRepository.save(newTask);

        return true;
    }
}
