package com.pvxdv.taskmanagementsystem.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UserDTO {
    private Long id;
    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDate birthdate;
    private String email;
}
