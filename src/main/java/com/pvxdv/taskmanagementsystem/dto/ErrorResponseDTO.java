package com.pvxdv.taskmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ErrorResponseDTO {
    private LocalDate creationDate;
    private int code;
    private String status;
    private String stackTrace;
    private String message;
}
