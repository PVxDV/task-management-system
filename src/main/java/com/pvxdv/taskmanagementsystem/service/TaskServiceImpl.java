package com.pvxdv.taskmanagementsystem.service;

import com.pvxdv.taskmanagementsystem.converter.TaskDTOToTask;
import com.pvxdv.taskmanagementsystem.converter.TaskToTaskDTO;
import com.pvxdv.taskmanagementsystem.converter.UserDTOToUser;
import com.pvxdv.taskmanagementsystem.dto.TaskDTO;
import com.pvxdv.taskmanagementsystem.enums.Status;
import com.pvxdv.taskmanagementsystem.exception.AccessErrorException;
import com.pvxdv.taskmanagementsystem.model.Task;
import com.pvxdv.taskmanagementsystem.model.User;
import com.pvxdv.taskmanagementsystem.repository.TaskRepository;
import com.pvxdv.taskmanagementsystem.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final TaskDTOToTask taskDTOToTask;
    private final TaskToTaskDTO taskToTaskDTO;
    private final UserDTOToUser userDTOToUser;
    public final String TASK_NOT_FOUND = "Task with id=%d not found";
    public final String USER_NOT_FOUND = "User with account=%s not found";

    @Override
    public TaskDTO findTaskById(Long taskId) throws EntityNotFoundException {
        if (taskRepository.findById(taskId).isPresent()) {
            return taskToTaskDTO.convert(taskRepository.findById(taskId).get());
        } else {
            throw new EntityNotFoundException(TASK_NOT_FOUND.formatted(taskId));
        }
    }

    @Override
    public TaskDTO updateTask(Long taskId, TaskDTO taskDTO) throws EntityNotFoundException {
        if (taskRepository.findById(taskId).isPresent()) {
            Task task = taskRepository.findById(taskId).get();

            if (taskDTO.getHeader() != null) {
                task.setHeader(taskDTO.getHeader());
            }
            if (taskDTO.getDescription() != null) {
                task.setDescription(taskDTO.getDescription());
            }
            if (taskDTO.getPriority() != null) {
                task.setPriority(taskDTO.getPriority());
            }

            taskRepository.save(task);

            return taskToTaskDTO.convert(task);

        } else {
            throw new EntityNotFoundException(TASK_NOT_FOUND.formatted(taskId));
        }
    }

    @Override
    public TaskDTO createTask(TaskDTO taskDTO) {
        Task task = taskRepository.save(taskDTOToTask.convert(taskDTO));

        task.setCreationDate(LocalDate.now());
        task.setUpdateDate(null);

        taskRepository.save(task);
        return taskToTaskDTO.convert(task);
    }

    @Override
    public void deleteTask(Long taskId) throws EntityNotFoundException {
        if (taskRepository.findById(taskId).isPresent()) {
            taskRepository.deleteById(taskId);
        } else {
            throw new EntityNotFoundException(TASK_NOT_FOUND.formatted(taskId));
        }
    }

    @Override
    public TaskDTO assignExecutorToTask(Long taskId, String account) throws EntityNotFoundException {
        if (taskRepository.findById(taskId).isPresent()) {
            if(userRepository.findByAccount(account).isPresent()) {
                Task task = taskRepository.findById(taskId).get();
                User executor = userRepository.findByAccount(account).get();

                task.setExecutor(executor);
                taskRepository.save(task);

                return taskToTaskDTO.convert(task);
            } else {
                throw new EntityNotFoundException(USER_NOT_FOUND.formatted(account));
            }
        } else {
            throw new EntityNotFoundException(TASK_NOT_FOUND.formatted(taskId));
        }
    }

    @Override
    public TaskDTO changeStatus(Long taskId, Status status, String account) throws EmptyResultDataAccessException, AccessErrorException {
        if (taskRepository.findById(taskId).isPresent()) {
            if(userRepository.findByAccount(account).isPresent()) {
                Task task = taskRepository.findById(taskId).get();
                if(Objects.equals(task.getExecutor().getAccount(), account)) {
                    task.setStatus(status);
                    taskRepository.save(task);
                    return taskToTaskDTO.convert(task);
                } else {
                    throw new AccessErrorException("A user with an account=%s  is trying to change the status of a task performed by a user with an account=%s".
                            formatted(account, task.getExecutor().getAccount()));
                }
            } else {
                throw new EntityNotFoundException(USER_NOT_FOUND.formatted(account));
            }
        } else {
            throw new EntityNotFoundException(TASK_NOT_FOUND.formatted(taskId));
        }
    }

    @Override
    public List<TaskDTO> findTasksByAuthor(Long AuthorId) throws EntityNotFoundException {
        //todo
        return null;
    }

    @Override
    public List<TaskDTO> findTasksByExecutor(Long ExecutorId) throws EntityNotFoundException {
        //todo
        return null;
    }
}
