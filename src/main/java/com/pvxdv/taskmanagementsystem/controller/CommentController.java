package com.pvxdv.taskmanagementsystem.controller;

import com.pvxdv.taskmanagementsystem.dto.CommentDTO;
import com.pvxdv.taskmanagementsystem.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tasks/{task_id}")
public class CommentController {
    private final CommentService commentService;
    @PostMapping(value = "/addComment", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommentDTO> addComment(@PathVariable Long task_id, @RequestBody CommentDTO commentDTO) {
        try{
            log.debug("REST request to add comment to task by task_id");
            return new ResponseEntity<>(commentService.addComment(task_id, commentDTO), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Task with id=%d not found".formatted(task_id));
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
