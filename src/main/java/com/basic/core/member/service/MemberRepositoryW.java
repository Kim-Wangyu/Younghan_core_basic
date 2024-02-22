package com.basic.core.member.service;

import com.basic.core.member.Member;

public interface MemberRepositoryW {

    void save(Member member);

    Member findById(Long memberId);
}
