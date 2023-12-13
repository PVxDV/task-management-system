package com.pvxdv.taskmanagementsystem.controller;

import com.pvxdv.taskmanagementsystem.dto.CommentDTO;
import com.pvxdv.taskmanagementsystem.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tasks/{task_id}")
public class CommentController {
    private final CommentService commentService;
    @PostMapping(value = "/addComment", consumes = APPLICATION_JSON_VALUE)
    public CommentDTO addComment(@PathVariable Long task_id, @RequestBody CommentDTO commentDTO) {
        return commentService.addComment(task_id, commentDTO);
    }
}
