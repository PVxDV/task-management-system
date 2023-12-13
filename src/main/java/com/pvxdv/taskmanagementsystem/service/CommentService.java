package com.pvxdv.taskmanagementsystem.service;

import com.pvxdv.taskmanagementsystem.dto.CommentDTO;

public interface CommentService {
    CommentDTO addComment(Long taskId, CommentDTO commentDTO);
}
