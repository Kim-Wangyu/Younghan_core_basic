package com.basic.core;

import com.basic.core.member.Grade;
import com.basic.core.member.Member;
import com.basic.core.member.MemberService;
import com.basic.core.member.MemberServiceImpl;
import com.basic.core.order.Order;
import com.basic.core.order.OrderService;
import com.basic.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();  2
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();


//        MemberService memberService = new MemberServiceImpl();  1
//        OrderService orderService = new OrderServiceImpl();

        //spring으로 바꾸기
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);


        Long memberId = 1L;
        Member member = new Member(memberId, "memberDS", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
