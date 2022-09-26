package com.basic.core;

import com.basic.core.discount.DiscountPolicy;
import com.basic.core.discount.FixDiscountPolicy;
import com.basic.core.discount.RateDiscountPolicy;
import com.basic.core.member.MemberRepository;
import com.basic.core.member.MemberService;
import com.basic.core.member.MemberServiceImpl;
import com.basic.core.member.MemoryMemberRepository;
import com.basic.core.order.OrderService;
import com.basic.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //서비스역할
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    //레포지토리 역할
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    //서비스역할
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    //구현체
    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
