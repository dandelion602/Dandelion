package com.dandelion.backend.service;

import com.dandelion.backend.entity.Deal;
import com.dandelion.backend.repository.DealRepository;
import com.dandelion.backend.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DealService {

    @Autowired
    DealRepository dealRepository;

    public List<Deal> findBySeller(int sellerNumber){

        return dealRepository.findBySeller(sellerNumber);
    }





}
