package com.basic.core;

import com.basic.core.member.Grade;
import com.basic.core.member.Member;
import com.basic.core.member.MemberService;
import com.basic.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig(); 2
//        //이 memberService는 memberServiceImpl을 뱉어내는 appConfig임.
//        MemberService memberService = appConfig.memberService();

//        MemberService memberService = new MemberServiceImpl(); 1 원래 여기서 메모리멤버를 자기가 생성시켰음

        //스프링으로 바꾸기
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);//( 이름(내가 무엇을 꺼낼것인지), 타입)

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("N member = " + member.getName());
        System.out.println("N findMember = " + findMember.getName());

    }
}
