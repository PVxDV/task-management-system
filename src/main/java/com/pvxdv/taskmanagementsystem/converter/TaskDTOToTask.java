package com.pvxdv.taskmanagementsystem.converter;

import com.pvxdv.taskmanagementsystem.dto.TaskDTO;
import com.pvxdv.taskmanagementsystem.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskDTOToTask {
    public Task convert(TaskDTO taskDTO){
        return new Task(taskDTO.getId(), taskDTO.getHeader(), taskDTO.getDescription(), taskDTO.getStatus(), taskDTO.getPriority(),
                taskDTO.getAuthor(), taskDTO.getExecutor(), taskDTO.getComments(), taskDTO.getCreationDate(), taskDTO.getUpdateDate());
    }
}
