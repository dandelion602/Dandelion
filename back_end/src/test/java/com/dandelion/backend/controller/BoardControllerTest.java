package com.dandelion.backend.controller;

import com.dandelion.backend.entity.Board;
import com.dandelion.backend.service.BoardService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BoardControllerTest {

    @Autowired
    BoardService boardService;

    @Test
    void searchWithTitle() throws Exception{
        Board board = new Board();
        board.setTitle("this is title");
        board.setContents("this is content");
        board.setPrice(2323);
        boardService.save(board);

        String part = "is";
        List<Board> searchedBoard = boardService.searchWithTitle(part);
        Assertions.assertThat(board.getTitle().contains(part)).isEqualTo(true);

    }
}