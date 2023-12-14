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
@Builder
@RequiredArgsConstructor
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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
