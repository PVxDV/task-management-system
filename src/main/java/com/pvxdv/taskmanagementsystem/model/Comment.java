package com.pvxdv.taskmanagementsystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@Table(name = "comments")
public class Comment extends BaseEntity {
    @NotNull
    @ManyToOne
    @JoinColumn(name = "author_id")
    User author;
    @NotNull
    @ManyToOne()
    @JoinColumn(name = "task_id")
    Task task;
    @NotBlank
    @Column(name = "comment")
    String comment;
    @NotNull
    @Column(name = "creation_date", columnDefinition = "TIMESTAMP")
    LocalDate creationTime;
}
