package com.pvxdv.taskmanagementsystem.model;

import com.pvxdv.taskmanagementsystem.model.enums.Priority;
import com.pvxdv.taskmanagementsystem.model.enums.Status;
import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Type;

import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = {"author", "executor"})
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @NotBlank
    @Column(name = "header")
    String header;
    @NotBlank
    @Lob
    @Column(name = "description")
    String description;
    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    Status status;
    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Column(name = "priority")
    Priority priority;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "author_id")
    Author author;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "executor_id")
    Executor executor;
    @Type(JsonBinaryType.class)
    @Column(name = "comments", columnDefinition = "jsonb")
    List<Comment> comments = new LinkedList<>();
}
