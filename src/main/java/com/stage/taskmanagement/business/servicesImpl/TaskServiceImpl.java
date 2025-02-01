package com.stage.taskmanagement.business.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.stage.taskmanagement.business.services.TaskService;
import com.stage.taskmanagement.dao.entities.Task;
import com.stage.taskmanagement.dao.repositories.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks(Boolean status, String sort) {
        Sort sorting = Sort.unsorted();

        if ("asc".equalsIgnoreCase(sort)) {
            sorting = Sort.by(Sort.Direction.ASC, "createdAt");
        } else if ("desc".equalsIgnoreCase(sort)) {
            sorting = Sort.by(Sort.Direction.DESC, "createdAt");
        }

        if (status != null) {
            return taskRepository.findByStatus(status);
        }

        return taskRepository.findAll(sorting);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        Optional<Task> existingTask = taskRepository.findById(id);
        if (existingTask.isPresent()) {
            Task updatedTask = existingTask.get();
            updatedTask.setName(task.getName());
            updatedTask.setStatus(task.getStatus());
            return taskRepository.save(updatedTask);
        }
        throw new RuntimeException("Task not found with id " + id);
    }

    @Override
    public void deleteTask(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
        } else {
            throw new RuntimeException("Task not found with id " + id);
        }
    }
}