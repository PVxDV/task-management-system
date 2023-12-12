package com.pvxdv.taskmanagementsystem.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Entity
@Data
public class Author extends BaseEntity {
    @NotBlank
    String name;
}
