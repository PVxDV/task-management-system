package com.pvxdv.taskmanagementsystem.service;


import com.pvxdv.taskmanagementsystem.dto.TaskDTO;
import com.pvxdv.taskmanagementsystem.enums.Status;
import com.pvxdv.taskmanagementsystem.exception.AccessErrorException;

import java.util.List;

public interface TaskService {
    TaskDTO findTaskById(Long taskId);
    TaskDTO updateTask(Long taskId, TaskDTO taskDTO);
    TaskDTO createTask(TaskDTO taskDTO);
    void deleteTask(Long id);
    TaskDTO changeStatus(Long taskId, Status status, String account) throws AccessErrorException;
    List<TaskDTO> findTasksByAuthor (Long authorId);
    List<TaskDTO> findTasksByExecutor (Long executorId);
    TaskDTO assignExecutorToTask(Long task_id, String account);
}
