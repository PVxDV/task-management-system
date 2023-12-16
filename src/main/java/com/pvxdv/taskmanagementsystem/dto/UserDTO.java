package com.pvxdv.taskmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthdate;
    private String email;
    private String account;
}
