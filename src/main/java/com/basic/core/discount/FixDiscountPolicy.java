package com.basic.core.discount;

import com.basic.core.member.Grade;
import com.basic.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; //1000원 할인인

   @Override
    public int discount(Member member, int price) {
       if(member.getGrade() == Grade.VIP){  //VIP면 무조건 천원할인 !
           return discountFixAmount;
       }else {
           return 0;
       }
    }
}
