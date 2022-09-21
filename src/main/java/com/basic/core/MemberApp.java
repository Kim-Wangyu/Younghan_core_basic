package com.basic.core;

import com.basic.core.member.Grade;
import com.basic.core.member.Member;
import com.basic.core.member.MemberService;
import com.basic.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("N member = " + member.getName());
        System.out.println("N findMember = " + findMember.getName());

    }
}
