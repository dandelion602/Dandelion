package com.dandelion.backend.service;

import com.dandelion.backend.entity.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class BaordServiceTest {

    @Autowired
    BoardService boardService;

    @Test
    public void findWithTitle() {
        Board board1 = new Board();
        Board board2 = new Board();

        board1.setTitle("this is new board1");
        board2.setTitle("this is new board2");
        board1.setContents("this is new content1");
        board2.setContents("this is new content2");
        board1.setPrice(2323);
        board2.setPrice(2323);
        boardService.save(board1);
        boardService.save(board2);

        List<Board> searchedBoards = boardService.searchWithTitle("new");
        System.out.println("****************************************");
        for (Board b: searchedBoards) {
            System.out.println(b.getTitle());
        }
    }
}
