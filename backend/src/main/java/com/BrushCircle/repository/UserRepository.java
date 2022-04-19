package com.BrushCircle.repository;

import com.BrushCircle.model.Product;
import com.BrushCircle.model.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long>, JpaSpecificationExecutor<Product> {

//    User findByUsername(String username);

//    @Query("SELECT * FROM users WHERE role='USER'")
//    List<User> getAllRegUsers();

//    User findByActivationCode(String code);

//    User findByPasswordResetCode(String code);

    User findByEmail(@Param("email") String email);

//    List<User> findAllUsers(Specification<User> spec);

//    @Query("SELECT * FROM user")
//    List<User> findAll();

    List<User> findAllByRole(@Param("role") String role);
    List<User> findAll();
}