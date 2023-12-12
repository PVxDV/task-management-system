package com.pvxdv.taskmanagementsystem.service;


import com.pvxdv.taskmanagementsystem.dto.TaskDTO;

public interface TaskService {
    TaskDTO findById(Long id);
    TaskDTO updateTask(Long id, TaskDTO taskDTO);
    TaskDTO createTask(TaskDTO taskDTO);
    void deleteTask(Long id);
}
