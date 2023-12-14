package com.pvxdv.taskmanagementsystem.service;

import com.pvxdv.taskmanagementsystem.converter.TaskDTOToTask;
import com.pvxdv.taskmanagementsystem.converter.TaskToTaskDTO;
import com.pvxdv.taskmanagementsystem.converter.UserDTOToUser;
import com.pvxdv.taskmanagementsystem.dto.TaskDTO;
import com.pvxdv.taskmanagementsystem.dto.UserDTO;
import com.pvxdv.taskmanagementsystem.enums.Status;
import com.pvxdv.taskmanagementsystem.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
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
    public TaskDTO findTaskById(Long taskId) {
        return null;
    }
    @Override
    public TaskDTO updateTask(Long taskId, TaskDTO taskDTO) {
        return null;
    }

    @Override
    public TaskDTO createTask(TaskDTO taskDTO) {
        return null;
    }

    @Override
    public void deleteTask(Long id) {
    }

    @Override
    public TaskDTO assignExecutorToTask(Long task_id, UserDTO Executor) {
        return null;
    }
    @Override
    public TaskDTO changeStatus(Long taskId, Status status) {
        return null;
    }

    @Override
    public List<TaskDTO> findTasksByAuthor(Long AuthorId) {
        return null;
    }

    @Override
    public List<TaskDTO> findTasksByExecutor(Long ExecutorId) {
        return null;
    }

}
