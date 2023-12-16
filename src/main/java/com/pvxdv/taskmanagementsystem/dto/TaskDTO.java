package com.pvxdv.taskmanagementsystem.dto;

import com.pvxdv.taskmanagementsystem.enums.Priority;
import com.pvxdv.taskmanagementsystem.enums.Status;
import com.pvxdv.taskmanagementsystem.model.Comment;
import com.pvxdv.taskmanagementsystem.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
    Long id;
    String header;
    String description;
    Status status;
    Priority priority;
    User author;
    User executor;
    List<Comment> comments;
    LocalDate creationDate;
    LocalDate updateDate;
}
