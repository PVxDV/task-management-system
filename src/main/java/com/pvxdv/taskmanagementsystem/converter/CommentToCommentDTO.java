package com.pvxdv.taskmanagementsystem.converter;

import com.pvxdv.taskmanagementsystem.dto.CommentDTO;
import com.pvxdv.taskmanagementsystem.model.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentToCommentDTO {
    public CommentDTO convert(Comment comment){
        return CommentDTO.builder()
                .author(comment.getAuthor())
                .comment(comment.getComment())
                .createTime(comment.getCreationTime())
                .build();
    }
}
