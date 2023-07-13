package com.animelist.repository;

import com.animelist.model.Role;
import com.animelist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);
    @Query("SELECT u FROM User u LEFT JOIN u.roles ur WHERE ur.roleName = :role")
    List<User> findAllByRole(Role role);
}
