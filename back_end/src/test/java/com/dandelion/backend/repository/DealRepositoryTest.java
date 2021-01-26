package com.dandelion.backend.repository;

import com.dandelion.backend.entity.Deal;
import com.dandelion.backend.service.BoardService;
import com.dandelion.backend.service.DealService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class DealRepositoryTest {

    @Autowired
    DealService dealService;
    @Autowired
    BoardService boardService;

    @Test
    public void dealTest() {
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%");
        Date date = new Date();
        System.out.println(date);


    }



}