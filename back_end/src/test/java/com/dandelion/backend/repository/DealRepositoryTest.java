package com.dandelion.backend.repository;

import com.dandelion.backend.entity.Deal;
import com.dandelion.backend.service.BoardService;
import com.dandelion.backend.service.DealService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class DealRepositoryTest {

    @Autowired
    DealService dealService;
    @Autowired
    BoardService boardService;
    @Autowired
    DealRepository dealRepository;

    @Test
    public void dealTest() {
//        Deal deal = dealService.findDealWithBoard(boardService.getOne(3));
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%");
//        System.out.println(deal.getNumber());
        System.out.println(new Date(System.currentTimeMillis()));


    }

    @Test
    public  void test1() {
        List<Deal> d = dealRepository.findBybuyerNumber(1);
        for (Deal deal : d) {
            System.out.println(deal.getNumber());
        }
    }



}