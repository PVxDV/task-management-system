package com.pvxdv.taskmanagementsystem.service;

import com.pvxdv.taskmanagementsystem.dto.CommentDTO;
import org.springframework.dao.EmptyResultDataAccessException;

public interface CommentService {
    CommentDTO addComment(Long taskId, CommentDTO commentDTO) throws EmptyResultDataAccessException;
}
