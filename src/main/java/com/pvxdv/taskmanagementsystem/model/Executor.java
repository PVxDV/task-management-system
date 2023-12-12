package com.pvxdv.taskmanagementsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Entity
@Data
public class Executor extends BaseEntity{
    @NotBlank
    @Column(name = "name")
    String name;
}
