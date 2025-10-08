package com.app.Todo.services;


import com.app.Todo.Models.Task;
import com.app.Todo.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
     return taskRepository.findAll();
    }

    public void createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public void toggleTask(Long id) throws IllegalAccessException {
        Task task= taskRepository.findById(id)
                .orElseThrow(() -> new  IllegalAccessException("Invalid task Id"));
              task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }
}
