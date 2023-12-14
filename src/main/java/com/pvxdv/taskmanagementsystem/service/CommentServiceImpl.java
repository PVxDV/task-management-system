package com.pvxdv.taskmanagementsystem.service;

import com.pvxdv.taskmanagementsystem.converter.CommentDTOToComment;
import com.pvxdv.taskmanagementsystem.converter.CommentToCommentDTO;
import com.pvxdv.taskmanagementsystem.dto.CommentDTO;
import com.pvxdv.taskmanagementsystem.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentToCommentDTO commentToCommentDTO;
    private final CommentDTOToComment commentDTOToComment;
    private final CommentRepository commentRepository;
    private final TaskService taskService;
    @Override
    public CommentDTO addComment(Long taskId, CommentDTO commentDTO) throws EmptyResultDataAccessException {
        return null;
    }
}
