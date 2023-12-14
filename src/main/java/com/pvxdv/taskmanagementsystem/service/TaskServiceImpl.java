package com.pvxdv.taskmanagementsystem.service;

import com.pvxdv.taskmanagementsystem.converter.TaskDTOToTask;
import com.pvxdv.taskmanagementsystem.converter.TaskToTaskDTO;
import com.pvxdv.taskmanagementsystem.converter.UserDTOToUser;
import com.pvxdv.taskmanagementsystem.dto.TaskDTO;
import com.pvxdv.taskmanagementsystem.dto.UserDTO;
import com.pvxdv.taskmanagementsystem.enums.Status;
import com.pvxdv.taskmanagementsystem.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskDTOToTask taskDTOToTask;
    private final TaskToTaskDTO taskToTaskDTO;
    private final UserDTOToUser userDTOToUser;

    @Override
    public TaskDTO findTaskById(Long taskId) throws EmptyResultDataAccessException {
        return null;
    }
    @Override
    public TaskDTO updateTask(Long taskId, TaskDTO taskDTO) throws EmptyResultDataAccessException {
        return null;
    }

    @Override
    public TaskDTO createTask(TaskDTO taskDTO) throws Exception {
        return null;
    }

    @Override
    public void deleteTask(Long id) throws EmptyResultDataAccessException{
    }

    @Override
    public TaskDTO assignExecutorToTask(Long task_id, UserDTO Executor) throws EmptyResultDataAccessException {
        return null;
    }
    @Override
    public TaskDTO changeStatus(Long taskId, Status status) throws EmptyResultDataAccessException {
        return null;
    }

    @Override
    public List<TaskDTO> findTasksByAuthor(Long AuthorId) throws EmptyResultDataAccessException {
        return null;
    }

    @Override
    public List<TaskDTO> findTasksByExecutor(Long ExecutorId) throws EmptyResultDataAccessException {
        return null;
    }

}
