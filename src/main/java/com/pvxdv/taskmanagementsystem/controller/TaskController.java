package com.pvxdv.taskmanagementsystem.controller;

import com.pvxdv.taskmanagementsystem.dto.TaskDTO;
import com.pvxdv.taskmanagementsystem.dto.UserDTO;
import com.pvxdv.taskmanagementsystem.enums.Status;
import com.pvxdv.taskmanagementsystem.service.TaskService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/tasks", consumes = APPLICATION_JSON_VALUE)
public class TaskController {
    public final String TASK_NOT_FOUND = "Task with id=%d not found";
    private final TaskService taskService;
    @GetMapping(value = "/{task_id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDTO> getTaskById (@PathVariable Long task_id) {
        try{
            log.debug("REST request to get task by task_id");
            return new ResponseEntity<>(taskService.findTaskById(task_id), HttpStatus.OK) ;
        } catch (EmptyResultDataAccessException e) {
        log.error(TASK_NOT_FOUND.formatted(task_id));
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //редактировать задачу PUT
    @PutMapping(value = "/{task_id}/edit", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDTO> editTask(@PathVariable Long task_id, @RequestBody TaskDTO taskDTO) {
        try{
            log.debug("REST request to edit task by task_id");
            return new ResponseEntity<>(taskService.updateTask(task_id, taskDTO), HttpStatus.OK) ;
        } catch (EmptyResultDataAccessException e) {
            log.error(TASK_NOT_FOUND.formatted(task_id));
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //создать задачу POST
    @PostMapping(value = "/new", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO) {
        try{
            log.debug("REST request to create new task");
            return new ResponseEntity<>(taskService.createTask(taskDTO), HttpStatus.CREATED) ;
        } catch (Exception e) {
            //todo Exception + log text
            log.error("Something wrong..");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    //удалить задачу DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{task_id}/delete")
    public void deleteTask(@PathVariable Long task_id) {
        try{
            log.debug("REST request to delete task by task_id");
            taskService.deleteTask(task_id);
        } catch (EmptyResultDataAccessException e) {
            log.error(TASK_NOT_FOUND.formatted(task_id));
        }
    }

    //добавить исполнителя Patch
    @PatchMapping(value = "/{task_id}/assignExecutor", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDTO> assignExecutor(@PathVariable Long task_id, @RequestBody UserDTO userDTO) {
        try{
            log.debug("REST request to assign a task executor by task_id");
            return new ResponseEntity<>(taskService.assignExecutorToTask(task_id, userDTO), HttpStatus.OK) ;
        } catch (EmptyResultDataAccessException e) {
            log.error(TASK_NOT_FOUND.formatted(task_id));
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    //изменить статус задачи Patch
    @PatchMapping(value = "/{task_id}/changeStatus")
    public ResponseEntity<TaskDTO> changeStatus(@PathVariable Long task_id, @RequestBody Status status) {
        try{
            log.debug("REST request to change the task status by task_id");
            return new ResponseEntity<>(taskService.changeStatus(task_id, status), HttpStatus.OK) ;
        } catch (EmptyResultDataAccessException e) {
            log.error(TASK_NOT_FOUND.formatted(task_id));
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //найти задачи по автору GET
    @GetMapping(value = "/byAuthor/{author_id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TaskDTO>> getTasksByAuthor (@PathVariable Long author_id) {
        try{
            log.debug("REST request to get task by author_id");
            return new ResponseEntity<>(taskService.findTasksByAuthor(author_id), HttpStatus.OK) ;
        } catch (EmptyResultDataAccessException e) {
            log.error("User with id=%d not found".formatted(author_id));
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //найти задачи по исполнителю GET
    @GetMapping(value = "/byExecutor/{executor_id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TaskDTO>> findTaskById (@PathVariable Long executor_id) {
        try{
            log.debug("REST request to get task by executor_id");
            return new ResponseEntity<>(taskService.findTasksByExecutor(executor_id), HttpStatus.OK) ;
        } catch (EmptyResultDataAccessException e) {
            log.error("User with id=%d not found".formatted(executor_id));
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
