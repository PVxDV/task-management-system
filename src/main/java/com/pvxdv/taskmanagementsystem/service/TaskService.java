package com.pvxdv.taskmanagementsystem.service;


import com.pvxdv.taskmanagementsystem.dto.TaskDTO;
import com.pvxdv.taskmanagementsystem.dto.UserDTO;
import com.pvxdv.taskmanagementsystem.enums.Status;

import java.util.List;

public interface TaskService {
    TaskDTO findTaskById(Long taskId);
    TaskDTO updateTask(Long taskId, TaskDTO taskDTO);
    TaskDTO createTask(TaskDTO taskDTO);
    void deleteTask(Long id);
    TaskDTO changeStatus(Long taskId, Status status);
    List<TaskDTO> findTasksByAuthor (Long AuthorId);
    List<TaskDTO> findTasksByExecutor (Long ExecutorId);
    TaskDTO assignExecutorToTask(Long task_id, UserDTO Executor);
}
