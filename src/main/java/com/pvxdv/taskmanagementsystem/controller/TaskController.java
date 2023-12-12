package com.pvxdv.taskmanagementsystem.controller;

import com.pvxdv.taskmanagementsystem.dto.TaskDTO;
import com.pvxdv.taskmanagementsystem.model.Task;
import com.pvxdv.taskmanagementsystem.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tasks")
public class TaskController {
    private final TaskService taskService;
    //посмотреть задачу GET
    @GetMapping(value = "/{task_id}", produces = APPLICATION_JSON_VALUE)
    public TaskDTO findTaskById (@PathVariable Long task_id) {
        return taskService.findById(task_id);
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

    //создать комментарий PUT

    //изменить статус задачи PUT

    //найти задачи по автору GET

    //найти задачи по исполнителю GET

}
