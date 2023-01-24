package com.example.board.repository;

import com.example.board.model.entity.Boards;
import com.example.board.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
