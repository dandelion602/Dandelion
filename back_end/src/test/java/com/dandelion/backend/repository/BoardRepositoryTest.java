package com.dandelion.backend.repository;

import com.dandelion.backend.entity.Board;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class BoardRepositoryTest {
    @Autowired
    BoardRepository boardRepository;

    @Test
    void getLastBoard() {
        Board board1 = new Board();
        Board board2 = new Board();

        board1.setTitle("first");
        board2.setTitle("last");
        board1.setPrice(3434);
        board2.setPrice(3434);
        board1.setContents("content");
        board2.setContents("content");
        boardRepository.save(board1);
        boardRepository.save(board2);

        Assertions.assertThat(board2.getTitle()).isEqualTo(boardRepository.findLastBoard().getTitle());
    }

}

