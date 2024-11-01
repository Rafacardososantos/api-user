package com.example.api_user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.api_user.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByNome(String Username);

   // User findById(int id);
}
