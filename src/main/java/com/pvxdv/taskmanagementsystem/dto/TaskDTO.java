package com.pvxdv.taskmanagementsystem.dto;

import com.pvxdv.taskmanagementsystem.model.Comment;
import com.pvxdv.taskmanagementsystem.model.User;
import com.pvxdv.taskmanagementsystem.enums.Priority;
import com.pvxdv.taskmanagementsystem.enums.Status;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TaskDTO {
    Long id;
    String header;
    String description;
    Status status;
    Priority priority;
    User author;
    User executor;
    List<Comment> comments;
}
