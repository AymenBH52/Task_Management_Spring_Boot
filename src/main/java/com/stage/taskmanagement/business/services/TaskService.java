package com.stage.taskmanagement.business.services;

import java.util.List;

import com.stage.taskmanagement.dao.entities.Task;

public interface TaskService {

    Task createTask(Task task);

    List<Task> getAllTasks(Boolean status, String sort);

    Task updateTask(Long id, Task task);

    void deleteTask(Long id);
    
}
