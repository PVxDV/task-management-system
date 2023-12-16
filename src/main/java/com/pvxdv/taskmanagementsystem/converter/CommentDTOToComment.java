package com.pvxdv.taskmanagementsystem.converter;

import com.pvxdv.taskmanagementsystem.dto.CommentDTO;
import com.pvxdv.taskmanagementsystem.model.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentDTOToComment {
    public Comment convert(CommentDTO commentDTO){
        return new Comment(null, commentDTO.getAuthor(), null, commentDTO.getComment(), null);
    }
}
