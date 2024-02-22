package com.basic.core.member.serviceImpl;

import com.basic.core.member.Member;
import com.basic.core.member.service.MemberRepositoryW;
import com.basic.core.member.service.MemberServiceW;

public class MemberServiceImplW implements MemberServiceW {

    MemberRepositoryW memberRepositoryW = new MemoryMemberRepositoryW();
    @Override
    public void join(Member member) {

        memberRepositoryW.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepositoryW.findById(memberId);
    }
}
