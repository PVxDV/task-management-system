package com.pvxdv.taskmanagementsystem.repository;

import com.pvxdv.taskmanagementsystem.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
