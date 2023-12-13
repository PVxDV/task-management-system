package com.pvxdv.taskmanagementsystem.dto;

import com.pvxdv.taskmanagementsystem.model.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CommentDTO {
    User author;
    String comment;
    LocalDate createTime;
}
