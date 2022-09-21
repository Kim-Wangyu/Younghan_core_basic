package com.basic.core.order;

import com.basic.core.member.Grade;
import com.basic.core.member.Member;
import com.basic.core.member.MemberService;
import com.basic.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberBB", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemBB", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
