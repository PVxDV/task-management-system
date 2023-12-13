package com.pvxdv.taskmanagementsystem.converter;

import com.pvxdv.taskmanagementsystem.dto.TaskDTO;
import com.pvxdv.taskmanagementsystem.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskToTaskDTO {
    public TaskDTO convert (Task task){
        return TaskDTO.builder()
                .id(task.getId())
                .header(task.getHeader())
                .status(task.getStatus())
                .priority(task.getPriority())
                .author(task.getAuthor())
                .executor(task.getExecutor())
                .build();
    }
}
