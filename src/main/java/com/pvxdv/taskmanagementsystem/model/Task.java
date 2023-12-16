package com.pvxdv.taskmanagementsystem.model;

import com.pvxdv.taskmanagementsystem.enums.Priority;
import com.pvxdv.taskmanagementsystem.enums.Status;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "tasks")
public class Task extends  BaseEntity{
    public Task(Long id, String header, String description, Status status, Priority priority, User author, User executor,
                List<Comment> comments, LocalDate creationDate, LocalDate updateDate) {
        super(id);
        this.header = header;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.author = author;
        this.executor = executor;
        if(comments == null || comments.size()>0){
            this.comments = comments;
        }
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    @NotBlank
    @Column(name = "header")
    private String header;
    @NotBlank
    @Lob
    @Column(name = "description")
    private String description;
    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status;
    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Column(name = "priority")
    private Priority priority;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
    @Nullable
    @ManyToOne
    @JoinColumn(name = "executor_id")
    private User executor;
    @Nullable
    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "comment_id")
    private List<Comment> comments;
    @NotNull
    @Column(name = "creation_date", columnDefinition = "TIMESTAMP")
    LocalDate creationDate;
    @Nullable
    @Column(name = "update_date", columnDefinition = "TIMESTAMP")
    LocalDate updateDate;
}
