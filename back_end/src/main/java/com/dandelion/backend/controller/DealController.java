package com.dandelion.backend.controller;

import com.dandelion.backend.entity.Deal;
import com.dandelion.backend.entity.member.Member;
import com.dandelion.backend.entity.member.MyMemberDetails;
import com.dandelion.backend.service.DealService;
import com.dandelion.backend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DealController {

    @Autowired
    MemberService memberService;

    @Autowired
    DealService dealService;


    @GetMapping(value = "order-history/sell")
    public List<Deal> sell(@AuthenticationPrincipal MyMemberDetails myMemberDetails){
        Member member = myMemberDetails.getMember();
//        memberService.findById(member.getId());

        return dealService.findBySeller(member.getNumber());
    }
}
