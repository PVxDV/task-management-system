package com.pvxdv.taskmanagementsystem.controller;

import com.pvxdv.taskmanagementsystem.dto.TaskDTO;
import com.pvxdv.taskmanagementsystem.dto.UserDTO;
import com.pvxdv.taskmanagementsystem.model.enums.Status;
import com.pvxdv.taskmanagementsystem.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tasks")
public class TaskController {
    private final TaskService taskService;
    //посмотреть задачу GET
    @GetMapping(value = "/{task_id}", produces = APPLICATION_JSON_VALUE)
    public TaskDTO getTaskById (@PathVariable Long task_id) {
        return taskService.findTaskById(task_id);
    }

    //редактировать задачу PUT
    @PutMapping(value = "/{task_id}/edit", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public TaskDTO editTask(@PathVariable Long task_id, @RequestBody TaskDTO taskDTO) {
        return taskService.updateTask(task_id, taskDTO);
    }

    //создать задачу POST
    @PostMapping(value = "/new", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public TaskDTO createTask(@RequestBody TaskDTO taskDTO) {
        return taskService.createTask(taskDTO);
    }

    //удалить задачу DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{task_id}/delete", consumes = APPLICATION_JSON_VALUE)
    public void deleteTask(@PathVariable Long task_id) {
        taskService.deleteTask(task_id);
    }

    //добавить исполнителя Patch
    @PatchMapping(value = "/{task_id}/assignExecutor", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public TaskDTO assignExecutor(@PathVariable Long task_id, @RequestBody UserDTO userDTO) {
        return taskService.assignExecutorToTask(task_id, userDTO);
    }


    //изменить статус задачи Patch
    @PatchMapping(value = "/{task_id}/changeStatus", consumes = APPLICATION_JSON_VALUE)
    public TaskDTO changeStatus(@PathVariable Long task_id, @RequestBody Status status) {
        return taskService.changeStatus(task_id, status);
    }

    //найти задачи по автору GET
    @GetMapping(value = "/byAuthor/{author_id}", produces = APPLICATION_JSON_VALUE)
    public List<TaskDTO> getTasksByAuthor (@PathVariable Long author_id) {
        return taskService.findTasksByAuthor(author_id);
    }

    //найти задачи по исполнителю GET
    @GetMapping(value = "/byExecutor/{executor_id}", produces = APPLICATION_JSON_VALUE)
    public List<TaskDTO> findTaskById (@PathVariable Long executor_id) {
        return taskService.findTasksByExecutor(executor_id);
    }

}
