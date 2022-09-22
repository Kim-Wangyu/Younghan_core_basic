package com.basic.core.discount;

import com.basic.core.member.Member;

public interface DiscountPolicy {
    /**
     * @return 할인 대상 금액 (천원이 할인되면 천원을 리턴)
     **/
    int discount(Member member, int price);


}
