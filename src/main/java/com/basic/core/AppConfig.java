package com.basic.core;

import com.basic.core.discount.FixDiscountPolicy;
import com.basic.core.member.MemberService;
import com.basic.core.member.MemberServiceImpl;
import com.basic.core.member.MemoryMemberRepository;
import com.basic.core.order.OrderService;
import com.basic.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
