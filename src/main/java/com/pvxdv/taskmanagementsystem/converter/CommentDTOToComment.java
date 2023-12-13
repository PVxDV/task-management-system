package com.pvxdv.taskmanagementsystem.converter;

import com.pvxdv.taskmanagementsystem.dto.CommentDTO;
import com.pvxdv.taskmanagementsystem.model.Comment;
import com.pvxdv.taskmanagementsystem.model.Task;
import org.springframework.stereotype.Component;

@Component
public class CommentDTOToComment {
    public Comment convert(CommentDTO commentDTO, Long task_id){
        return Comment.builder()
                .author(commentDTO.getAuthor())
                .comment(commentDTO.getComment())
                .task(Task.builder().id(task_id).build())
                .creationTime(commentDTO.getCreateTime())
                .build();
    }
}
