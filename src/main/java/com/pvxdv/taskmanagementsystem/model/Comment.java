package com.pvxdv.taskmanagementsystem.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Comment {
    @NotNull
    Author author;
    @NotBlank
    String comment;
}
