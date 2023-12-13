package com.pvxdv.taskmanagementsystem.dto;

import com.pvxdv.taskmanagementsystem.model.User;
import com.pvxdv.taskmanagementsystem.model.enums.Priority;
import com.pvxdv.taskmanagementsystem.model.enums.Status;
import lombok.Builder;
import lombok.Data;

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
}
