package com.pvxdv.taskmanagementsystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "comments")
public class Comment extends BaseEntity {

    @Builder
    public Comment(Long id, User author, Task task, String comment, LocalDate creationTime) {
        super(id);
        this.author = author;
        this.task = task;
        this.comment = comment;
        this.creationTime = creationTime;
    }
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
