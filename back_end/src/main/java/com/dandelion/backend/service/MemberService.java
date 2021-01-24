package com.dandelion.backend.service;


import com.dandelion.backend.entity.form.MemberModifyForm;
import com.dandelion.backend.entity.member.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    Member signUp(Member user);

    Member memberUpdate(Member member, MemberModifyForm memberModifyForm);

    Optional<Member> findById(String id);

//    findByPoint(String id);
    List<Member> findAll();
}
