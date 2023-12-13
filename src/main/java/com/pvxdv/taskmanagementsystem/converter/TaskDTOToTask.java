package com.pvxdv.taskmanagementsystem.converter;

import com.pvxdv.taskmanagementsystem.dto.TaskDTO;
import com.pvxdv.taskmanagementsystem.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskDTOToTask {
    public Task convert(TaskDTO taskDTO){
        return Task.builder()
                .id(taskDTO.getId())
                .header(taskDTO.getHeader())
                .status(taskDTO.getStatus())
                .priority(taskDTO.getPriority())
                .author(taskDTO.getAuthor())
                .executor(taskDTO.getExecutor())
                .build();
    }
}
