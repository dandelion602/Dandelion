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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DealController {

    @Autowired
    MemberService memberService;

    @Autowired
    DealService dealService;

    @GetMapping(value = "order-history/sell")
    public List<Deal> sell(@AuthenticationPrincipal MyMemberDetails myMemberDetails){
        Member member = myMemberDetails.getMember();
        return dealService.findBySeller(member.getNumber());
    }

    @GetMapping(value = "order-history/buy")
    public List<Deal> buy(@AuthenticationPrincipal MyMemberDetails myMemberDetails){
        Member member = myMemberDetails.getMember();

        return dealService.findByBuyer(member.getNumber());
    }
}
