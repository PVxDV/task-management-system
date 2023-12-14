package com.pvxdv.taskmanagementsystem.service;


import com.pvxdv.taskmanagementsystem.dto.TaskDTO;
import com.pvxdv.taskmanagementsystem.dto.UserDTO;
import com.pvxdv.taskmanagementsystem.enums.Status;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

public interface TaskService {
    TaskDTO findTaskById(Long taskId)throws EmptyResultDataAccessException;
    TaskDTO updateTask(Long taskId, TaskDTO taskDTO)throws EmptyResultDataAccessException;
    TaskDTO createTask(TaskDTO taskDTO) throws Exception;
    void deleteTask(Long id);
    TaskDTO changeStatus(Long taskId, Status status)throws EmptyResultDataAccessException;
    List<TaskDTO> findTasksByAuthor (Long AuthorId)throws EmptyResultDataAccessException;
    List<TaskDTO> findTasksByExecutor (Long ExecutorId)throws EmptyResultDataAccessException;
    TaskDTO assignExecutorToTask(Long task_id, UserDTO Executor)throws EmptyResultDataAccessException;
}
