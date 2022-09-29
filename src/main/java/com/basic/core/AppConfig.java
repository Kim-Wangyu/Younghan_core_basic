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

    //싱글톤이 깨진게 아닌가!?
    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository()
    //아래에서 2번 호출이 되니 중첩이 되고 , 싱글톤이 깨졌다고 생각하는게 정상 !

    //서비스역할
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    } //여기서 한번

    //레포지토리 역할
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    //서비스역할
    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }//여기서 한번

    //구현체
    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
