package com.BrushCircle.repository;

import com.BrushCircle.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

    List<User> getAllUsers();

    User findByActivationCode(String code);

    User findByPasswordResetCode(String code);

    User findByEmail(@Param("email") String email);


}