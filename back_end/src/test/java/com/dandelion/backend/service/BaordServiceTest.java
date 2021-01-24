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
    public void test () {
        List<Board> b = boardService.findMyBoard(2);
        System.out.println(b.get(0).getTitle());
    }

    @Test
    public void test1 () {
        Board b = boardService.getOne(13);
        b.setStatus(1);
        boardService.save(b);
        System.out.println(b.getTitle());
    }
}
