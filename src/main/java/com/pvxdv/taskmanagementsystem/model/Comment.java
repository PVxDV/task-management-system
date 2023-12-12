package com.pvxdv.taskmanagementsystem.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Comment {
    @NotNull
    Author author;
    @NotBlank
    String comment;
}
