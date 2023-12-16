package com.pvxdv.taskmanagementsystem.repository;

import com.pvxdv.taskmanagementsystem.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByAccount(String account);
}
