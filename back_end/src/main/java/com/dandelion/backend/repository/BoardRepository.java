package com.dandelion.backend.repository;

import com.dandelion.backend.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BoardRepository extends JpaRepository<Board, Integer> {

    @Query(value = "SELECT * FROM board ORDER BY number DESC LIMIT 1;", nativeQuery = true)
    Board findLastBoard();

    @Query("select b from Board b where b.title like %?1%")
    List<Board> searchWithTitle(String title);

}