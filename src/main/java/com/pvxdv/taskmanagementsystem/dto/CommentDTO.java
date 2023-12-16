package com.pvxdv.taskmanagementsystem.dto;

import com.pvxdv.taskmanagementsystem.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    User author;
    String comment;
    LocalDate createTime;
}
