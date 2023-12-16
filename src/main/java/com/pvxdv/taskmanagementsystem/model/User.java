package com.pvxdv.taskmanagementsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "users")
public class User extends BaseEntity{

    @Builder
    public User(Long id, String firstName, String lastName, String middleName, LocalDate birthdate, String email, String account) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthdate = birthdate;
        this.email = email;
        this.account = account;
    }

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "birth_date", columnDefinition = "DATE")
    private LocalDate birthdate;
    @Column(name = "email")
    private String email;
    @Column(name = "account")
    private String account;


}
