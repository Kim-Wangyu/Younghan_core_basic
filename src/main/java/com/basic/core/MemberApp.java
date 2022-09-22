package com.basic.core;

import com.basic.core.member.Grade;
import com.basic.core.member.Member;
import com.basic.core.member.MemberService;
import com.basic.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        //이 memberService는 memberServiceImpl을 뱉어내는 appConfig임.
        MemberService memberService = appConfig.memberService();

//        MemberService memberService = new MemberServiceImpl(); 원래 여기서 메모리멤버를 자기가 생성시켰음

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("N member = " + member.getName());
        System.out.println("N findMember = " + findMember.getName());

    }
}
