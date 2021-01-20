package com.dandelion.backend.controller;


import com.dandelion.backend.entity.member.Member;
import com.dandelion.backend.entity.member.MyMemberDetails;
import com.dandelion.backend.service.MemberService;
import com.dandelion.backend.utils.TokenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/user")
@Log4j2
@CrossOrigin(origins = "*")
public class MemberController {

    private final BCryptPasswordEncoder passwordEncoder;
    private final MemberService memberService;

    @PostMapping(value = "/signUp")
    public ResponseEntity signUp(@RequestBody Member member) {
        member.setPw(passwordEncoder.encode(member.getPw()));
        return memberService.findById(member.getId()).isPresent()
                ? ResponseEntity.badRequest().build()
                : ResponseEntity.ok(TokenUtils.generateJwtToken(memberService.signUp(member)));
    }

//    @PostMapping(value = "/signUp")
//    public ResponseEntity signUp(HttpServletRequest request) {
//        System.out.println("------------------------------------");
//        Enumeration<String> headerNames = request.getParameterNames();
//        System.out.println("------------------------------------");
//        System.out.println(headerNames);
//        Member member = new Member();
//        return memberService.findById("aa").isPresent()
//                ? ResponseEntity.badRequest().build()
//                : ResponseEntity.ok(TokenUtils.generateJwtToken(memberService.signUp(member)));
//    }

//    @GetMapping(value = "/findAll")
//    public ResponseEntity findAll() {
//        return ResponseEntity.ok(memberService.findAll());
//    }

    @GetMapping(value = "/findAll")
    public ResponseEntity findMe(@AuthenticationPrincipal MyMemberDetails myMemberDetails) {
        return ResponseEntity.ok(memberService.findById(myMemberDetails.getId()));

    }
}
