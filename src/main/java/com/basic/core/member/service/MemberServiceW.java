package com.basic.core.member.service;

import com.basic.core.member.Member;

public interface MemberServiceW {

    void join(Member member);

    Member findMember(Long memberId);


}
