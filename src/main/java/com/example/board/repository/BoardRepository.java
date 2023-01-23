package com.example.board.repository;

import com.example.board.model.entity.Boards;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Boards, Long> {

    List<Boards> findByTitle(String title);
    List<Boards> findByTitleOrContent(String title, String content);

    Page<Boards> findByTitleContainingOrContentContaining(String title, String content, Pageable pageable);
}
