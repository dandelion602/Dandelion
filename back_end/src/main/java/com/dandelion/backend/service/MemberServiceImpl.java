package com.dandelion.backend.service;

import com.dandelion.backend.entity.member.Member;
import com.dandelion.backend.repository.MemberRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService{

    @NonNull
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member signUp(Member user) {
        return memberRepository.save(user);
    }

    @Override
    public Optional<Member> findById(String id) {
        return memberRepository.findById(id);
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
      }

}
