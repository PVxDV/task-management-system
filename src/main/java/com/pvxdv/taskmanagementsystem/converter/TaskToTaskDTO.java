package com.pvxdv.taskmanagementsystem.converter;

import com.pvxdv.taskmanagementsystem.dto.TaskDTO;
import com.pvxdv.taskmanagementsystem.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskToTaskDTO {
    public TaskDTO convert (Task task){
        return new TaskDTO(task.getId(), task.getHeader(), task.getDescription(), task.getStatus(), task.getPriority(),
                task.getAuthor(), task.getExecutor(), task.getComments(), task.getCreationDate(), task.getUpdateDate());
    }
}
