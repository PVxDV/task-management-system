package com.pvxdv.taskmanagementsystem.dto;

import com.pvxdv.taskmanagementsystem.model.Author;
import com.pvxdv.taskmanagementsystem.model.Comment;
import com.pvxdv.taskmanagementsystem.model.Executor;
import com.pvxdv.taskmanagementsystem.model.enums.Priority;
import com.pvxdv.taskmanagementsystem.model.enums.Status;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Data
@RequiredArgsConstructor
@Builder
public class TaskDTO {
    Long id;
    String header;
    String description;
    Status status;
    Priority priority;
    Author author;
    Executor executor;
    List<Comment> comments = new LinkedList<>();
}
